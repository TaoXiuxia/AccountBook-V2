function setLeftColumn(){
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#borrow").addClass("left-column-button-inactive");
	$("#borrow").addClass("left-column-button-inactive-font");
	$("#history").addClass("left-column-button-active");
	$("#history").addClass("left-column-button-active-font");
	$("#itemsManagement").addClass("left-column-button-inactive");
	$("#itemsManagement").addClass("left-column-button-inactive-font");
	$("#monthlyStatistics").addClass("left-column-button-inactive");
	$("#monthlyStatistics").addClass("left-column-button-inactive-font");
}

function search(){
	var type = $("#type option:selected").val();
	var year = $("#year option:selected").val();
	var month = $("#month option:selected").val();
	var keyword = $("#keyword").val();
	$.ajax({
		type: "POST",
		url: "searchHistory",
		data: {
			"type":type,
			"year":year,
			"month":month,
			"keyword":keyword
		},
		success: function(msg){
			$("#details  tr:not(:first)").empty("");  // 将表格置为空
			var len = msg.list.length;
			for(var i=0;i<len;i++){
				var operation = 
					"<a href='#' onClick=changeDetailsItem('" +
						msg.list[i].itemType +"','"+
						msg.list[i].id +"','"+
						msg.dateList[i]  +"','"+
						msg.list[i].money  +"','"+
						msg.list[i].itemId +"','"+
						msg.list[i].remark +"'"+
					")>修改</a>"+ 
				
					"<a href='#' onClick=delDetailsItem('"+
						msg.list[i].itemType +"','"+
						msg.list[i].id +"'"+
					")>删除</a>";
				$("#detailItems").append(
					"<tr>"+
		            "    <td>"+ msg.dateList[i] +"</td>"+
		            "    <td>"+ msg.list[i].money +"</td>"+
		            "    <td>"+ msg.typeList[i] +"</td>"+
		            "    <td>"+ msg.list[i].itemName +"</td>"+
		            "    <td>"+ msg.list[i].remark +"</td>"+
		            "    <td>"+ operation +"</td>"+
		            "</tr>"
				)
			}
		},
		error: function () {//XMLHttpRequest, textStatus, errorThrown
			alert("请求失败");
		} 
	});
}

function changeType1(){
	var content = $(".layui-layer-content");
	var changedType = content.find("#changedType").val();
	if(changedType=='in'){
		content.find("#changedItem .ex").addClass("hidden");
		content.find("#changedItem .in").removeClass("hidden");
	}else{
		content.find("#changedItem .in").addClass("hidden");
		content.find("#changedItem .ex").removeClass("hidden");
	}
}

function changeDetailsItem(itemType, detailsId, date, money, itemId, remark){
	layer.confirm(
		$("#changeDetailsItemLayer").html(),{
	    btn: ['修改','返回'], //按钮
		success: function(layero, index){
       		var content = $(".layui-layer-content");
 		   	content.find("#changedDate").val(date.substring(0,10));
 		   	content.find("#changedMoney").val(money);
 		   	content.find("#changedType").val(itemType);
 		   	content.find("#changedItem").val(itemId);
 		   	content.find("#changedRemark").val(remark);
 		    changeType1();
        }
	}, function(){
		var content = $(".layui-layer-content");
		var changedDate = content.find("#changedDate").val();
		var changedMoney = content.find("#changedMoney").val();
		var changedType = content.find("#changedType").val();
		var changedItem = content.find("#changedItem").val();
		var changedRemark = content.find("#changedRemark").val();
		$.post("../historyController/changeHistory",{
			"itemType":itemType,  // 原项的类型（收入or支出）
			"changedType":changedType,  // 现在的类型（收入or支出）
			"detailsId":detailsId,
			"changedDate":changedDate,
			"changedMoney":changedMoney,
			"changedItem":changedItem,
			"changedRemark":changedRemark
		});
		setTimeout('location.reload()', 1000);
	});
}

function delDetailsItem(itemType,historyId,itemId){
	$.post("../historyController/deleHistory",{
		"itemType":itemType,
		"historyId":historyId,
		"itemId":itemId,
	});
	setTimeout('location.reload()', 1000);
}
