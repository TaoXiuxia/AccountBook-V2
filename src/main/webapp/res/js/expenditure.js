// 设置flag，防止充分点击，多次提交
var flag = true;

function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-active");
	$("#expenditure").addClass("left-column-button-active-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#payMethodsManagement").addClass("left-column-button-inactive");
	$("#payMethodsManagement").addClass("left-column-button-inactive-font");
	$("#about").addClass("left-column-button-inactive");
	$("#about").addClass("left-column-button-inactive-font");
}

/**
 * 添加支出
 */
function addMoney(){
	if(flag == true){
		flag = false;
		var date = $("#date").val();
		var item = $("#item option:selected").val();
		var money = $("#money").val();
		var moneyType = $("#money-type option:selected").val();
		var remark = $("#remarkForExpenditure").val();
		remark = replaceEnter2Space(remark);
		$.post("addExpenditure",{
			"date":date,
			"item":item,
			"money":money,
			"moneyType":moneyType,
			"remark":remark
		});
		setTimeout('location.reload()', 1000);
	}
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
       		remark = replaceEnter2Space(remark);
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
function delExpenditure(expenditureId){
	layer.confirm('确认删除？', {
		  btn: ['删除','返回'] //按钮
	}, function(){
		$.post("../expenditureController/deleExpenditure",{
			"expenditureId":expenditureId,
		});
		setTimeout('location.reload()', 1000);
	}, function(){
	});
}
