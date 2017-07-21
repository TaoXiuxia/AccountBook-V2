function setLeftColumn(){
	$("#income").addClass("left-column-button-active");
	$("#income").addClass("left-column-button-active-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#about").addClass("left-column-button-inactive");
	$("#about").addClass("left-column-button-inactive-font");
}

/**
 * 增加收入
 */
function addMoney(){
	var date = $("#date").val();
	var item = $("#item option:selected").val();
	var money = $("#money").val();
	var moneyType = $("#money-type option:selected").val();
	var remark = $("#remarkForIncome").val();
	$.post("addIncome",{
		"date":date,
		"item":item,
		"money":money,
		"moneyType":moneyType,
		"remark":remark
	});
	setTimeout('location.reload()', 1000);
}

/**
 * 修改收入
 * @param incomeId
 * @param date
 * @param money
 * @param itemId
 * @param remark
 * @param money_type
 */
function changeIncome(incomeId,date,money,itemId,remark,money_type){
	layer.confirm(
		$("#addContent").html(),{
	    btn: ['修改','返回'], //按钮
	    success: function(layero, index){
	    	var content = $(".layui-layer-content");
			content.find("#changedDate").val(date);
       		content.find("#changedMoney").val(money);
       		content.find("#changedItem").val(itemId);
       		content.find("#changed-money-type").val(money_type);
       		content.find("#changedRemark").val(remark);
        }
		}, function(){
			var content = $(".layui-layer-content");
			var date = content.find("#changedDate").val();
       		var money = content.find("#changedMoney").val();
       		var changed_money_type = content.find("#changed-money-type").val();
       		var itemId = content.find("#changedItem option:selected").val();
       		var remark = content.find("#changedRemark").val();
			$.post("../incomeController/changeIncome",{
				"incomeId":incomeId,
				"money":money,
				"moneyType":changed_money_type,
				"itemId":itemId,
				"remark":remark,
				"date":date
			});
			setTimeout('location.reload()', 1000);
		});
}

/**
 * 删除收入
 * @param incomeId
 * @param itemId
 */
function delIncome(incomeId, itemId){
	$.post("../incomeController/deleIncome",{
		"incomeId":incomeId,
		"itemId":itemId
	});
	setTimeout('location.reload()', 1000);
}

