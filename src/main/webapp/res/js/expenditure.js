function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-active");
	$("#expenditure").addClass("left-column-button-active-font");
	$("#borrow").addClass("left-column-button-inactive");
	$("#borrow").addClass("left-column-button-inactive-font");
}

function addMoney(){
	var item = $("#item option:selected") .val();
	var money = $("#money").val();
	var remark = $("#remarkForIncome").val();
	$.post("expenditure",{
		"type":1,    //1表示添加支出
		"item":item,
		"money":money,
		"remark":remark
	});
	location.reload();
}

function addItem(){
	var itemName = $("#itemName").val();
	var remark = $("#remarkForItem").val();
	$.post("expenditure",{
		"type":2,   //2表示添加支出项
		"itemName":itemName,
		"remark":remark
	});
	location.reload();
}

