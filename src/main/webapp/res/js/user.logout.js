function logout() {
	$.ajax({
		type: "POST",
		url: "/AccountBook-V2/userController/logout.action",
		data: {
		},
		success: function(msg){
			if(msg.info=="注销成功"){
				layer.msg(msg.info);
				setTimeout(function(){
					window.location.href="../userController/showUserLogin";
				},1500);
			}
		},
		error: function () {
			layer.msg("登录失败");
		} 
	});
}

