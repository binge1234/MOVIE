// JavaScript Document
var editIndex = null;

layui.use(['layedit', 'form', 'layer', 'laypage'], function(){
    var layedit = layui.layedit
	,form = layui.form
	,layer = layui.layer
	,laypage = layui.laypage;
	
    layedit.set({
      uploadImage: {
        url: '/upload/article' //接口url
        ,type: 'post' //默认post
      }
    });

   editIndex = layedit.build('reply',{
      height: 150, //设置编辑器高度
      tool: ['strong', 'italic', 'underline', 'left', 'center', 'right', '|', 'link', 'image', 'code']
    }); //建立编辑器

});

function getReply(){
	layui.use(['layedit','layer','form'], function(){
		var layedit = layui.layedit
			,layer = layui.layer
			,form = layui.form;
			
		//自定义验证规则
		  form.verify({
			reply: function(value){
				var reply = layedit.getContent(editIndex);  //获取编辑器的内容
				if(reply.length <= 0){
					return '文章内容不能为空';
				}else{

// 					//获取添加的ui
// 					var ul = document.getElementById("jieda");
// 					//创建li
// 					var li = document.createElement("li");
// 					//设置id="newli"  data-id='14'
// 					li.setAttribute("id", "newli");
// 					li.setAttribute("data-id", "14");
// 					li.innerHTML = html;
// 　　					ul.appendChild(li);
// 					document.getElementById("testReply").innerHTML = reply;
// 					console.log(reply);
				}
			}
		  });
        form.on("submit(addComment)",function(data){
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            data.field.content=layedit.getContent(editIndex);
            $.ajax({
                type: "POST",
                url: "/console/comment/add",  //后台程序地址
                data:data.field,
                success: function(data){           //后台程序返回的标签，比如我喜欢使用1和0 表示成功或者失败
                    if (data.status==200){   //如果成功了
                        layer.close(index);
                        layer.msg('提交成功');  //成功后需要做的事情，这里随便你这么操作！
                        window.location.reload();//刷新当前页面
                    }
                }
            })
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。

        })
	});
}
