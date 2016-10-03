function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#borrow").addClass("left-column-button-inactive");
	$("#borrow").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-inactive");
	$("#history").addClass("left-column-button-inactive-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#monthlyStatistics").addClass("left-column-button-active");
	$("#monthlyStatistics").addClass("left-column-button-active-font");
}

function addMoney(){
	var actualBalance = $("#actualBalance").val();
	$.post("../monthlyStatisticsController/addBalance",{
		"actualBalance":actualBalance
	});
	setTimeout('location.reload()', 1000);
}

function changeMoney(){
	balanceId
	var balanceId = $("#balanceId").val();
	var actualBalance = $("#actualBalance").val();
	alert(actualBalance);
	$.post("../monthlyStatisticsController/changeBalance",{
		"balanceId":balanceId,
		"actualBalance":actualBalance
	});
	setTimeout('location.reload()', 1000);
}

function toExcel(){
	alert("本部分还没有做");
}