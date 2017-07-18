function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-active");
	$("#expenditure").addClass("left-column-button-active-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#about").addClass("left-column-button-inactive");
	$("#about").addClass("left-column-button-inactive-font");
}

/**
 * 在日期框中填入今天的日期，（默认当前日期）；
 */
function fillUpDate(){ 
	var myDate = new Date();
	var myDate=myDate.toLocaleDateString();
	$("#date").val(myDate);
}

/**
 * 在“本月实际结余”输入框中填入数值（如果有的话）,并且将其变为不可用
 * @param actualSurplus  查询到的实际结余
 */
function unenableInput(actualSurplus){ 
	if(actualSurplus!=-1){ //-1表示没有内容
		$("#actual_balance").val(actualSurplus);
		$("#actual_balance").attr("disabled","disabled");
		$("#submitBalanceButton").attr("disabled","disabled");
	}
}

/**
 * 添加支出
 */
function addMoney(){
	var date = $("#date").val();
	var item = $("#item option:selected").val();
	var money = $("#money").val();
	var moneyType = $("#money-type option:selected").val();
	var remark = $("#remarkForExpenditure").val();
	$.post("addExpenditure",{
		"date":date,
		"item":item,
		"money":money,
		"moneyType":moneyType,
		"remark":remark
	});
	setTimeout('location.reload()', 1000);
}

/**
 * 修改支出
 * @param expenditureId
 * @param date
 * @param money
 * @param itemId
 * @param remark
 */
function changeExpenditure(expenditureId,date,money,itemId,remark,money_type){
	layer.confirm(
		$("#addContent").html(),{
	    btn: ['修改','返回'],
	    success: function(layero, index){
	    	var content = $(".layui-layer-content");
			content.find("#changedDate").val(date);
       		content.find("#changedMoney").val(money);
       		content.find("#changedItem").val(itemId);
       		content.find("#changed-money-type").val(money_type);
       		content.find("#changedRemark").val(remark);
        }//按钮
		}, function(){
			var content = $(".layui-layer-content");
			var date = content.find("#changedDate").val();
       		var money = content.find("#changedMoney").val();
       		var changed_money_type = content.find("#changed-money-type").val();
       		var itemId = content.find("#changedItem option:selected").val();
       		var remark = content.find("#changedRemark").val();
			$.post("../expenditureController/changeExpenditure",{
				"expenditureId":expenditureId,
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
 * 删除支出
 * @param expenditureId
 * @param itemId
 */
function delExpenditure(expenditureId, itemId){
	$.post("../expenditureController/deleExpenditure",{
		"expenditureId":expenditureId,
		"itemId":itemId
	});
	setTimeout('location.reload()', 1000);
}
