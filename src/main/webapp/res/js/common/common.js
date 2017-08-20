/**
 * 在日期框中填入今天的日期，（默认当前日期）；
 */
function fillUpDate(){ 
	var myDate = new Date().Format("yyyy-MM-dd");
	$("#date").val(myDate);
}

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

// 来源： http://www.cnblogs.com/zhangpengshou/archive/2012/07/19/2599053.html
// 对Date的扩展，将 Date转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

//列表项上移下移，用于项目管理和收支方式管理
function upAndDown(type, inOrex, id, upAndDown){
	var target;
	if(type == "item"){
		targetUrl = "../itemController/upAndDownItem";
	}else if(type == "typeOfMoney"){
		targetUrl = "...urlurlurlurlurl";   // 收入支出方式的url
	}
	
	$.ajax({
		type: "POST",
		url: targetUrl,
		data: {
			"inOrEx":inOrex,
			"itemId":id,
			"upAndDown":upAndDown
		},
		success: function(msg){
			layer.msg(msg.info);
			setTimeout(function(){
				location.reload();
			},1000);
		},
		error: function (msg) {//XMLHttpRequest, textStatus, errorThrown
			alert("请求失败");
		} 
	});
}