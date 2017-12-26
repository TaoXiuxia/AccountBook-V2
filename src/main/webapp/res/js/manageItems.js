function addItem(inOrEx){
	layer.confirm(
		$("#addItemLayer").html(),{
	    btn: ['添加','返回'] //按钮
		}, function(){
			var content = $(".layui-layer-content");
       		var itemName = content.find("#addedItemName").val();
       		var remark = content.find("#addedItemRemark").val();
       		
       		if(!validateNotEmpty(itemName, "项目名称不能为空")){
    			return false;
    		}
       		if(!validateLength(itemName, 0, 199, "项目名称不能超过199个字符")){
    			return false;
    		}
       		if(!validateLength(remark, 0, 199, "备注不能超过199个字符")){
    			return false;
    		}
       		
			$.post("../itemController/addItem",{
				"itemName":itemName,
				"remark":remark,
				"inOrEx":inOrEx
			});
			setTimeout('location.reload()', 1000);
		});
}

function changeItem(itemId, itemName,remark,inOrEx){
	layer.confirm(
		$("#addItemLayer").html(),{
	    btn: ['修改','返回'], //按钮
		success: function(layero, index){
       		var content = $(".layui-layer-content");
 		   	content.find("#addedItemName").val(itemName);
 		   	content.find("#addedItemRemark").val(remark);
        }
	}, function(){
		var content = $(".layui-layer-content");
		var itemName = content.find("#addedItemName").val();
		var remark = content.find("#addedItemRemark").val();
		if(!validateNotEmpty(itemName, "项目名称不能为空")){
			return false;
		}
   		if(!validateLength(itemName, 0, 199, "项目名称不能超过199个字符")){
			return false;
		}
   		if(!validateLength(remark, 0, 199, "备注不能超过199个字符")){
			return false;
		}
		$.post("../itemController/changeItem",{
			"itemId":itemId,
			"itemName":itemName,
			"remark":remark,
			"inOrEx":inOrEx
		});
		setTimeout('location.reload()', 1000);
	});
}

function delItem(itemId){
	layer.confirm('确认删除？', {
		  btn: ['删除','返回'] //按钮
	}, function(){
		$.post("../itemController/deleItem",{
			"itemId":itemId,
		});
		setTimeout('location.reload()', 1000);
	}, function(){
	});
}
