/**
 * jqGrid封装
 *
 * @param config
 *  jqGrid_id jqGrid id
 *  data 数据或数据的url
 *  datatype 从服务器端返回的数据类型，默认xml。可选类型：xml，local，json，jsonnp，script，xmlstring，jsonstring，clientside
 */
function MyJqGrid(config) {
    config = jQuery.extend(true, {
        // 这里面是默认参数
        jqGrid_id: null,
        data: null,
        datatype: 'json',
        autowidth: true,
        shrinkToFit: true,
        autoScroll: true,
        rowNum: 20,
        rowList: [10, 20, 30, 50],
        pager: 'pager',
        isSubGrid: false,
        loadonce: false,
        colNames:[],
        colModel:[],
        dataId: 'id',
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
        subGridRowExpanded: function () {

        },
        gridComplete: function () {

        },
        doResize: function () {
            var winW, winH;
            if (window.innerHeight) {// all except IE
                winW = window.innerWidth;
                winH = window.innerHeight;
            } else if (document.documentElement && document.documentElement.clientHeight) {// IE 6 Strict Mode
                winW = document.documentElement.clientWidth;
                winH = document.documentElement.clientHeight;
            } else if (document.body) { // other
                winW = document.body.clientWidth;
                winH = document.body.clientHeight;
            }  // for small pages with total size less then the viewport H: 230

            var $fieldSet = $('.layui-elem-field');
            var fieldSetH = $fieldSet.css('display') === 'block' ? $fieldSet.outerHeight(): 0;
            // console.log($fieldSet.outerHeight() + '  ' + fieldSetH);

            $jqGrid.jqGrid('setGridWidth', winW - 5).jqGrid('setGridHeight',
                winH - 125
                - $("#search").outerHeight()
                - fieldSetH);
            $jqGrid.closest(".ui-jqgrid-bdiv").css({'overflow-x': 'scroll'});
        }
    }, config);

    $.jgrid.defaults.styleUI = "Bootstrap";

    var $jqGrid = $("#" + config.jqGrid_id);

    /*
     * 创建jqGrid
     */
    $jqGrid.jqGrid({
        url: config.data,
        data: config.data,
        datatype: config.datatype,
        autowidth: config.autowidth,
        shrinkToFit: config.shrinkToFit,
        autoScroll: config.autoScroll,
        rowNum: config.rowNum,
        rowList: config.rowList,
        loadonce: config.loadonce,
        colNames: config.colNames,
        colModel: config.colModel,
        pager: "#" + config.pager,
        multiselect: true,
        viewrecords: true,
        recordpos: "left",
        hidegrid: false,
        altclass: "ui-priority-secondary",
        altRows: true,

        prmNames: config.prmNames,
        jsonReader: config.jsonReader,
        dataId: config.dataId,
        subGrid: config.isSubGrid,
        gridComplete: function () {
            config.gridComplete();
            config.doResize();
        },
        subGridRowExpanded: config.subGridRowExpanded,
        subGridRowColapsed: function (subgrid_id, row_id) {
            var subgrid_table_id;
            subgrid_table_id = subgrid_id + "_t";
            $("#" + subgrid_table_id).remove();
        }

    });
    $jqGrid.jqGrid('setFrozenColumns');

    /**
     * 刷新jqGrid(本地)
     * @param postData
     */
    $jqGrid.reloadGrid_local = function (postData) {
        $jqGrid.jqGrid('setGridParam', {
            datatype: 'local',
            postData: postData
        }).trigger("reloadGrid");
    };

    /**
     * 刷新jqGrid(url)
     * @param postData
     */
    $jqGrid.reloadGrid = function (postData) {
        $jqGrid.jqGrid('setGridParam', {
            datatype: 'json',
            page: 1,
            postData: postData || {}
        }).trigger("reloadGrid");
    };

    /**
     * 刷新jqGrid(url 当前页)
     */
    $jqGrid.reloadGrid_current = function () {
        $jqGrid.jqGrid('setGridParam', {
            datatype: 'json',
        }).trigger("reloadGrid");
    };

    /**
     * jqGrid自适应
     */
    $jqGrid.doResize = config.doResize;

    $jqGrid.doResize();
    $(window).on("resize", function () {
        $jqGrid.doResize();
    });

    return $jqGrid;
}

