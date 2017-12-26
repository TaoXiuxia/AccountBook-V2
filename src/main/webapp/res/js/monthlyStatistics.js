/**
 * 在“本月实际结余”输入框中填入数值（如果有的话）,并且将其变为不可用
 * @param actualSurplus
 */
function unenableInput(actualSurplus){ 
	if(actualSurplus!=-1){ //-1表示没有内容
		$("#actual_balance").val(actualSurplus);
		$("#actual_balance").attr("disabled","disabled");
		$("#submitBalanceButton").attr("disabled","disabled");
	}
}

/**
 * 用在收入和支出页面
 */

function submitBalance(){
	var actualBalance = $("#actual_balance").val();
	if(!validateNumOnly(actualBalance, "金额只能是数字")){
		return false;
	}
	$.post("../monthlyStatisticsController/addBalance",{
		"actualBalance":actualBalance
	});
	setTimeout('location.reload()', 1000);
}

/**
 * 修改balance 
 * @param month
 */
function changeBalance(month, value1, balanceId){ // 如果参数month为last，表示修改上月balance；如果参数为this，表示修改本月balance
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
	    	content.find("#changed_balance").val(value1);
        }
		}, function(){
			var content = $(".layui-layer-content");
			var changed_balance = content.find("#changed_balance").val();
			if(!validateNumOnly(changed_balance, "金额只能是数字")){
				return false;
			}
       		$.post("../monthlyStatisticsController/changeBalance",{
				"changed_balance":changed_balance,
				"balanceId":balanceId
			});
			setTimeout('location.reload()', 1000);
		});
}
