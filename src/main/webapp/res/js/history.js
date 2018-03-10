//设置年份，从2016年到今年
function setYear(){
	var nowDate = new Date().Format("yyyy-MM-dd");
	var thisYear = parseInt(nowDate.substring(0,4));
	for(var i=2016;i<=thisYear;i++){
		$("#year").append("<option value='"+i+"'>"+i+"</option>");
	}
}
//设置月份，只有选择了年份，才能选择月份。不能单选择月份
function setMonthEnable(){
	var s = document.getElementById("month");
	var options=$("#year option:selected");  //获取选中的项
	var year = options.val()
	if(year==-1){
		s.disabled = true;
	}else{
		s.disabled = false;
	}
}

/**
 * 前一页/后一页
 * @param foreOrBackward
 * @param totalPages
 */
function  gotoPage(foreOrBackward){
	totalPages = $("#totalPages").text();
	var page = parseInt($("#curPage").text()) + parseInt(foreOrBackward);
	if(page < 1){
		page = 1;
	}else if(page > totalPages){
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
								msg.list[i].payMethodId +"','"+
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
				            "    <td>"+ msg.list[i].payMethodName +"</td>"+
				            "    <td>"+ money +"</td>"+
				            "    <td>"+ msg.list[i].remark +"</td>"+
				            "    <td>"+ operation +"</td>"+
				            "</tr>"
						);
						
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

/**
 * 根据选择的是 收入还是支出 修改其具体的项目
 */
function changeType1(){
	var content = $(".layui-layer-content");
	var changedType = content.find("#changedType").val();
	if(changedType=='in'){
		content.find("#changedItem .ex").addClass("hidden");
		content.find("#changedItem .in").removeClass("hidden");
		content.find("#changedtype_of_money .ex").addClass("hidden");
		content.find("#changedtype_of_money .in").removeClass("hidden");
	}else{
		content.find("#changedItem .in").addClass("hidden");
		content.find("#changedItem .ex").removeClass("hidden");
		content.find("#changedtype_of_money .in").addClass("hidden");
		content.find("#changedtype_of_money .ex").removeClass("hidden");
	}
}

/**
 * 修改收入或者支出
 * @param itemType
 * @param detailsId
 * @param date
 * @param money
 * @param itemId
 * @param remark
 * @param type_of_money
 * @param curPage
 */
function changeDetailsItem(itemType, detailsId, date, money, itemId, remark, type_of_money, curPage){
	layer.confirm(
		$("#changeDetailsItemLayer").html(),{
	    btn: ['修改','返回'], //按钮
	    success: function(layero, index){
       		var content = $(".layui-layer-content");
 		   	content.find("#changedDate").val(date.substring(0,10));
 		   	content.find("#changedMoney").val(money);
 		   	content.find("#changedType").val(itemType);
 		   	content.find("#changedItem").val(itemId);
 		    remark = replaceEnter2Space(remark);
 		   	content.find("#changedRemark").val(unescape(remark)); //反转义（处理空格）
 		    content.find("#changedtype_of_money").val(type_of_money);
 		    changeType1();
        }
		}, function(){
			var content = $(".layui-layer-content");
			var changedDate = content.find("#changedDate").val();
			var changedMoney = content.find("#changedMoney").val();
			var changedType = content.find("#changedType").val();
			var changedItem = content.find("#changedItem").val();
			var changedRemark = content.find("#changedRemark").val();
			var changedtype_of_money = content.find("#changedtype_of_money").val();
			$.post("../historyController/changeHistory",{
				"itemType":itemType,  // 原项的类型（收入or支出）
				"changedType":changedType,  // 现在的类型（收入or支出）
				"detailsId":detailsId,
				"changedDate":changedDate,
				"changedMoney":changedMoney,
				"changedItem":changedItem,
				"changedRemark":changedRemark,
				"changedMoneyType":changedtype_of_money
			});
			
			setTimeout(function(){
				gotoPage(0, curPage);
				layer.closeAll();
			},800);
			
		});
}

/**
 * 删除收入或者支出
 * @param itemType
 * @param historyId
 * @param itemId
 * @param curPage
 */
function delDetailsItem(itemType,historyId, curPage){
	layer.confirm('确认删除？', {
		  btn: ['删除','返回'] //按钮
	}, function(){
		  $.post("../historyController/deleHistory",{
				"itemType":itemType,
				"historyId":historyId,
			});
			
			setTimeout(function(){
				gotoPage(0, curPage);
				layer.closeAll();
			},800);
	}, function(){
	});
}
