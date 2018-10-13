/**
 * jqGrid封装
 */
var my_jqGrid = function(){

	/**
	 * 创建jqGrid
	 * @param jqGrid_id jqGrid id
	 * @param data 数据或数据的url
	 * @param datatype 从服务器端返回的数据类型，默认xml。可选类型：xml，local，json，jsonnp，script，xmlstring，jsonstring，clientside
	 */
	var create_jqGrid = function (jqGrid_id, data, datatype, flag, rowNum, isSubGrid, subGridRowExpanded, gridComplete){
	
		if(datatype == undefined || datatype == null){
			datatype = "json";
		}
		var rowList;
		if(rowNum == undefined || rowNum == null){
			rowNum = 20;
			rowList = [10, 20, 30,50];
		}else{
			
			rowList = [rowNum];
		}
		
		if(flag == undefined || flag == null){
			var flag = true;
		}
		
		if(pager == undefined || pager == null){
			var pager = "pager";
		}
		
		$.jgrid.defaults.styleUI="Bootstrap";
		$("#" + jqGrid_id).jqGrid({

			url: data,
			data : data,
			datatype : datatype,
			autowidth : flag,
			shrinkToFit:flag,
			autoScroll: flag,
			rowNum : rowNum,
			rowList : rowList,
			colNames : colNames,
			colModel : colModel,
			pager : "#" + pager,
			multiselect : true,
			viewrecords : true,
			recordpos : "left",
			hidegrid : false,
			altclass : "ui-priority-secondary",
			altRows : true,

			prmNames: {     // 自定义Ajax请求参数  
	            page:"pageNumber", rows:"pageSize", sort: "orderColunm",  
	            order: "orderMode", search:"_search", nd:"nd", id:"id",  
	            oper:"oper",editoper:"edit",addoper:"add",deloper:"del",   
	            subgridid:"id", npage: null, totalrows:"total"  
	        },
	        jsonReader: {   // 自定义表格的JSON读取参数  
	            root: "list", page: "page",
	            total: "total", records: "records"
	        },  
	        dataId: 'id',
			subGrid : isSubGrid,
			gridComplete:gridComplete,
			subGridRowExpanded : subGridRowExpanded,
			subGridRowColapsed : function(subgrid_id, row_id) {
					var subgrid_table_id;
					subgrid_table_id = subgrid_id+"_t";
					$("#"+subgrid_table_id).remove();
				}
	        
		});
		$("#" + jqGrid_id).jqGrid('setFrozenColumns');
		_doResize(jqGrid_id);
		
		$(window).bind("resize",function(){
			_doResize(jqGrid_id);
		});
		
	};
	
	/**
	 * 刷新jqGrid(本地)
	 * @param jqGrid_id jqGrid id
	 */
	var reloadGrid_local = function(jqGrid_id, postData){
		 $("#" + jqGrid_id).jqGrid('setGridParam',
				 {
			 		datatype : 'local',
			 		postData : postData
				 }).trigger("reloadGrid");
	}
	
	/**
	 * 刷新jqGrid(url)
	 * @param jqGrid_id jqGrid id
	 */
	var reloadGrid = function(jqGrid_id, postData){
		
		if(postData == undefined){
			postData = {};
		}
		
		 $("#" + jqGrid_id).jqGrid('setGridParam',
				 {
			 		datatype : 'json',
			 		page : 1,
			 		postData : postData
				 }).trigger("reloadGrid");
	}
	
	/**
	 * 刷新jqGrid(url 当前页)
	 * @param jqGrid_id jqGrid id
	 */
	var reloadGrid_current = function(jqGrid_id){
		 $("#" + jqGrid_id).jqGrid('setGridParam',
				 {
			 		datatype : 'json',
				 }).trigger("reloadGrid");
	}
	
	
	/**
	 * jqGrid自适应
	 * @param jqGrid_id jqGrid id
	 */
	var _doResize = function(jqGrid_id) {
		 var winW, winH;
		 if(window.innerHeight) {// all except IE
		   	winW = window.innerWidth;
		   	winH = window.innerHeight;
		  } else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
		   	winW = document.documentElement.clientWidth;
		   	winH = document.documentElement.clientHeight;
		  } else if (document.body) { // other
		  	 winW = document.body.clientWidth;
		   	winH = document.body.clientHeight;
		  }  // for small pages with total size less then the viewport H: 230
		  $("#" + jqGrid_id).jqGrid('setGridWidth', winW - 5).jqGrid('setGridHeight', winH - 125  - $("#search").height());
		  $("#" + jqGrid_id).closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'scroll' });
	};
	
	
	
	return {
			
		_doResize : _doResize,
		
		create_jqGrid : create_jqGrid,
		reloadGrid : reloadGrid,
		reloadGrid_local : reloadGrid_local,
		reloadGrid_current : reloadGrid_current,
	};
	
}();

