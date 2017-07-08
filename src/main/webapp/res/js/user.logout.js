function logout() {
	$.ajax({
		type: "POST",
		url: "/AccountBook-V2/userController/logout.action",
		data: {
		},
		success: function(msg){
			alert(msg.info);
			if(msg.info=="注销成功"){
				window.location.href="../incomeController/showIncome";
			}
		},
		error: function () {
			alert("登录失败from前台");
		} 
	});
}

