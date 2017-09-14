//本文件中的js方法用于income和Expenditure页面中的搜索和页面跳转
//现在还没有做

/**
 * 前一页/后一页
 * @param forOrBackward
 * @param totalPages
 */
function  gotoPage(forOrBackward, totalPages){
	var page = parseInt($("#curPage").text()) + parseInt(forOrBackward);
	if(page < 1){
		page = 1;
	}else if(page>totalPages){
		page = totalPages;
	}
	search(page);
}

/**
 * 搜索第n页的数据
 * @param page
 */
function search(page){
	var type = $("#type option:selected").val();
	var year = $("#year option:selected").val();
	var month = $("#month option:selected").val();
	var keyword = $("#keyword").val();
	var sortBy = $("#sortBy option:selected").val(); 
	$.ajax({
		type: "POST",
		url: "searchHistory",
		data: {
			"type":type,
			"year":year,
			"month":month,
			"keyword":keyword,
			"sortBy":sortBy,
			"curPage":page
		},
		success: function(msg){
			$("#details  tr:not(:first)").empty("");  // 将表格置为空
				if(msg.list!=null){
					var len = msg.list.length;
					for(var i=0;i<len;i++){
						var operation = 
							"<a href='#' onClick=changeDetailsItem('" +
								msg.list[i].itemType +"','"+
								msg.list[i].id +"','"+
								msg.dateList[i]  +"','"+
								msg.list[i].money  +"','"+
								msg.list[i].itemId +"','"+
								escape(msg.list[i].remark) +"','"+    //转义
								msg.list[i].type_of_money +"','"+
								page +"'"+
							")>修改</a>&nbsp;&nbsp;&nbsp;"+ 
							"<a href='#' onClick=delDetailsItem('"+
								msg.list[i].itemType +"','"+
								msg.list[i].id +"','"+
								page +"',"+
							")>删除</a>";
						
						//处理金额money：如果金额为整数，如10元，则处理为10.0元
						var money;
						if(msg.list[i].money*100%100==0){
							money = msg.list[i].money+".0";
						}else{
							money =msg.list[i].money
						}
						
						$("#detailItems").append(
							"<tr>"+
				            "    <td>"+ msg.dateList[i] +"</td>"+
				            "    <td>"+ msg.typeList[i] +"</td>"+
				            "    <td>"+ msg.list[i].itemName +"</td>"+
				            "    <td>"+ msg.list[i].type_of_money +"</td>"+
				            "    <td>"+ money +"</td>"+
				            "    <td>"+ msg.list[i].remark +"</td>"+
				            "    <td>"+ operation +"</td>"+
				            "</tr>"
						)
				}
			}
			$("#curPage").text(msg.curPage);
			$("#totalPages").text(msg.totalPages);
			$("#totalRecords").text(msg.totalRecords);
		},
		error: function (msg) {//XMLHttpRequest, textStatus, errorThrown
			alert("请求失败");
		} 
	});
}

