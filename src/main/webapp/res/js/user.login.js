// 点击验证码图片换验证码
function refreshCheckCodeButton(){
	$(refreshCheckCode).find("img").attr("src", "checkCode.action?" + new Date());
}

// 注册
function login() {
	var account = $("#account").val();
	var password = $("#password").val();
	var checkCode = $("#checkCode").val();
	var rememberMe = $("#rememberMe").is(':checked');
	
	$.ajax({
		type: "POST",
		url: "login.action",
		data: {
			"account":account,
			"password":password,
			"checkCode":checkCode,
			"rememberMe":rememberMe
		},
		success: function(msg){
			if(msg.info=="登录成功"){
				window.location.href="../expenditureController/showExpenditure";
			}
		},
		error: function () {
			alert("登录失败from前台");
		} 
	});
}

// 按 enter 键提交
$(document).keyup(function(event) {
	var code = event.keyCode;
	if (code == 13) {
		login();
	}
})
