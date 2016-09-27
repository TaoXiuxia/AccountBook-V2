function setLeftColumn(){
	$("#income").addClass("left-column-button-active");
	$("#income").addClass("left-column-button-active-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#borrow").addClass("left-column-button-inactive");
	$("#borrow").addClass("left-column-button-inactive-font");
}

function addMoney(){
	var item = $("#item option:selected") .val();
	var money = $("#money").val();
	var remark = $("#remarkForIncome").val();
	$.post("income",{
		"type":1,
		"item":item,
		"money":money,
		"remark":remark
	});
	location.reload();
}

function addItem(){
	var itemName = $("#itemName").val();
	var remark = $("#remarkForItem").val();
	$.post("income",{
		"type":2,
		"itemName":itemName,
		"remark":remark
	});
	location.reload();
}

