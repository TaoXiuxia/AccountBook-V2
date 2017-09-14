function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#payMethodsManagement").addClass("left-column-button-active");
	$("#payMethodsManagement").addClass("left-column-button-active-font");
	$("#about").addClass("left-column-button-inactive");
	$("#about").addClass("left-column-button-inactive-font");
}

function changePayMethod(payMethodId, payMethodName, isCountInThisMonthEx, remark, inOrEx){
	layer.confirm(
		$("#addPayMethodLayer").html(),{
	    btn: ['修改','返回'], //按钮
	    area: ['420px', '260px'], //宽高
		success: function(layero, index){
			var content = $(".layui-layer-content");
 		   	content.find("#addedPayMethodName").val(payMethodName);
 		   	content.find("#addedPayMethodRemark").val(remark);
 		   	if(inOrEx == "in"){  //收入
 		   		var div1 = content.find("#isCountInThisMonthExDiv"); //这样得到的div1是一个集合
 		   		div1[0].style.display = "none";
 		   	}else{ //支出
 		   		content.find("#added_isCountInThisMonthEx").val(isCountInThisMonthEx);
 		   	}
        }
	}, function(){
		var content = $(".layui-layer-content");
		var payMethodName = content.find("#addedPayMethodName").val();
		var isCountInThisMonthEx = content.find("#added_isCountInThisMonthEx").val();
		if(isCountInThisMonthEx == "" || isCountInThisMonthEx == " "|| isCountInThisMonthEx == null){
			var isCountInThisMonthEx = -1;
		}
		var remark = content.find("#addedPayMethodRemark").val();
		$.post("../payMethodController/changePayMethod",{
			"payMethodId":payMethodId,
			"payMethodName":payMethodName,
			"isCountInThisMonthEx":isCountInThisMonthEx,
			"remark":remark
		});
		setTimeout('location.reload()', 1000);
	});
}

function delPayMethod(payMethodId){
	layer.confirm('确认删除？', {
		btn: ['删除','返回'] //按钮
	}, function(){
		$.post("../payMethodController/delePayMethod",{
			"payMethodId":payMethodId,
		});
		setTimeout('location.reload()', 1000);
	}, function(){
	});
}

function addPayMethod(inOrEx){
	layer.confirm(
		$("#addPayMethodLayer").html(),{
	    btn: ['添加','返回'], //按钮
		area: ['420px', '260px'], //宽高
		success: function(layero, index){
			var content = $(".layui-layer-content");
 		   	if(inOrEx == "in"){  //收入
 		   		var div1 = content.find("#isCountInThisMonthExDiv");
 		   		div1[0].style.display = "none";
 		   	}
        }
	}, function(){
		var content = $(".layui-layer-content");
		var payMethodName = content.find("#addedPayMethodName").val();
		var isCountInThisMonthEx = content.find("#added_isCountInThisMonthEx  option:selected").val();
		if(inOrEx == "in"){
			var isCountInThisMonthEx = -1;
		}
		var remark = content.find("#addedPayMethodRemark").val();
		$.post("../payMethodController/addPayMethod",{
			"payMethodName":payMethodName,
			"isCountInThisMonthEx":isCountInThisMonthEx,
			"remark":remark,
			"inOrEx":inOrEx
		});
		setTimeout('location.reload()', 1000);
	});
}

