function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-active");
	$("#expenditure").addClass("left-column-button-active-font");
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
	var item = $("#item option:selected") .val();
	var money = $("#money").val();
	var remark = $("#remarkForExpenditure").val();
	$.post("addExpenditure",{
		"item":item,
		"money":money,
		"remark":remark
	});
	setTimeout('location.reload()', 1000);
}

function changeExpenditure(expenditureId,date,money,itemId,remark){
	
	layer.confirm(
		$("#addContent").html(),{
	    btn: ['修改','返回'],
	    success: function(layero, index){
	    	var content = $(".layui-layer-content");
			content.find("#changedDate").val(date);
       		content.find("#changedMoney").val(money);
       		content.find("#changedItem").val(itemId);
       		content.find("#changedRemark").val(remark);
        }//按钮
		}, function(){
			var content = $(".layui-layer-content");
			var date = content.find("#changedDate").val();
       		var money = content.find("#changedMoney").val();
       		var itemId = content.find("#changedItem option:selected").val();
       		var remark = content.find("#changedRemark").val();
			$.post("../expenditureController/changeExpenditure",{
				"expenditureId":expenditureId,
				"money":money,
				"itemId":itemId,
				"remark":remark,
				"date":date
			});
			setTimeout('location.reload()', 1000);
		});
}

function delExpenditure(expenditureId, itemId){
	$.post("../expenditureController/deleExpenditure",{
		"expenditureId":expenditureId,
		"itemId":itemId
	});
	setTimeout('location.reload()', 1000);
}
