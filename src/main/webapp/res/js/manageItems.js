function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-active");
	$("#itemsManagement").addClass("left-column-button-active-font");
	$("#payMethodsManagement").addClass("left-column-button-inactive");
	$("#payMethodsManagement").addClass("left-column-button-inactive-font");
	$("#about").addClass("left-column-button-inactive");
	$("#about").addClass("left-column-button-inactive-font");
}

function addItem(inOrEx){
	layer.confirm(
		$("#addItemLayer").html(),{
	    btn: ['添加','返回'] //按钮
		}, function(){
			var content = $(".layui-layer-content");
       		var itemName = content.find("#addedItemName").val();
       		var remark = content.find("#addedItemRemark").val();
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
