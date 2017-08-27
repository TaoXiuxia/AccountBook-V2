// 点击验证码图片换验证码
function refreshCheckCodeButton(){
	$(refreshCheckCode).find("img").attr("src", "checkCode.action?" + new Date());
}

// 注册
function register() {
	
	var userName = $("#userName").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	var checkCode = $("#checkCode").val();
	
	if (password != repassword) {
		alert("两次输入的密码不一致");
		return;
	}
	$.ajax({
		type: "POST",
		url: "register.action",
		data: {
			"userName":userName,
			"email":email,
			"password":password,
			"checkCode":checkCode
		},
		success: function(msg){
			if(msg.info=="注册成功,请登录"){
				layer.msg(msg.info);
				setTimeout(function(){
					window.location.href="../userController/showUserLogin.action";
				},2000);
			}
			if(msg.info=="验证码错误"){
				layer.msg(msg.info);
			}
		},
		error: function () {
			alert("注册失败from前台");
		} 
	});
}

// 按 enter 键提交
$(document).keyup(function(event) {
	var code = event.keyCode;
	if (code == 13) {
		register();
	}
})
