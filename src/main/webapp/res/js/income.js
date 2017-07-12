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

function fillUpDate(){ //在日期框中填入今天的日期，（默认当前日期）；
	var myDate = new Date();
	var myDate=myDate.toLocaleDateString();
	$("#date").val(myDate);
}

function unenableInput(actualSurplus){ //在“本月实际结余”输入框中填入数值（如果有的话）,并且将其变为不可用
	if(actualSurplus!=-1){ //-1表示没有内容
		$("#actualSurplus").val(actualSurplus);
		$("#actualSurplus").attr("disabled","disabled");
	}
}

function changeBalance(month){ // 如果参数month为last，表示修改上月balance；如果参数为this，表示修改本月balance
	layer.confirm(
		$("#changeBalance").html(),{
	    btn: ['修改','返回'], //按钮
	    success: function(layero, index){
	    	var content = $(".layui-layer-content");
	    	if(month=="last"){
	    		content.find("#month_label").text("修改本月初/上月末结余：");
	    	}else{
	    		content.find("#month_label").text("修改本月末结余：");
	    	}
        }
		}, function(){
			var content = $(".layui-layer-content");
			var changed_balance = content.find("#changed_balance").val();
			
       		$.post("../monthlyStatisticsController/changeBalance",{
				"changed_balance":changed_balance,
				"month":month
			});
			setTimeout('location.reload()', 1000);
		});
}

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

function delIncome(incomeId, itemId){
	$.post("../incomeController/deleIncome",{
		"incomeId":incomeId,
		"itemId":itemId
	});
	setTimeout('location.reload()', 1000);
}

