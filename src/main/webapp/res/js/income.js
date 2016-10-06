function setLeftColumn(){
	$("#income").addClass("left-column-button-active");
	$("#income").addClass("left-column-button-active-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#borrow").addClass("left-column-button-inactive");
	$("#borrow").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#monthlyStatistics").addClass("left-column-button-inactive");
	$("#monthlyStatistics").addClass("left-column-button-inactive-font");
}

function addMoney(){
	var item = $("#item option:selected").val();
	var money = $("#money").val();
	var remark = $("#remarkForIncome").val();
	$.post("addIncome",{
		"item":item,
		"money":money,
		"remark":remark
	});
	setTimeout('location.reload()', 1000);
}

function changeIncome(incomeId,date,money,itemId,remark){
	
	layer.confirm(
		$("#addContent").html(),{
	    btn: ['修改','返回'], //按钮
	    success: function(layero, index){
	    	var content = $(".layui-layer-content");
			content.find("#changedDate").val(date);
       		content.find("#changedMoney").val(money);
       		content.find("#changedItem").val(itemId);
       		content.find("#changedRemark").val(remark);
        }
		}, function(){
			var content = $(".layui-layer-content");
			var date = content.find("#changedDate").val();
       		var money = content.find("#changedMoney").val();
       		var itemId = content.find("#changedItem option:selected").val();
       		var remark = content.find("#changedRemark").val();
			$.post("../incomeController/changeIncome",{
				"incomeId":incomeId,
				"money":money,
				"itemId":itemId,
				"remark":remark,
				"date":date
			});
			setTimeout('location.reload()', 1000);
		});
}

function delIncome(incomeId, itemId){
	$.post("../incomeController/deleIncome",{
		"incomeId":incomeId,
		"itemId":itemId
	});
	setTimeout('location.reload()', 1000);
}

