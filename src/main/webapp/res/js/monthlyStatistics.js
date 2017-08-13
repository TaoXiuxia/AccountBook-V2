/**
 * 用在收入和支出页面
 */

function submitBalance(){
	var actualBalance = $("#actual_balance").val();
	$.post("../monthlyStatisticsController/addBalance",{
		"actualBalance":actualBalance
	});
	setTimeout('location.reload()', 1000);
}

/**
 * 修改balance 
 * @param month
 */
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
