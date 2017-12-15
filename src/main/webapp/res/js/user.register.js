// 点击验证码图片换验证码
function refreshCheckCodeButton(){
	$(refreshCheckCode).find("img").attr("src", "checkCode.action?" + new Date());
}

// 注册
function register() {
	if(!validator()){
		return;
	}
	
	var userName = $("#userName").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	var checkCode = $("#checkCode").val();
	
	// loading
	var index = layer.load(1, {
	  shade: [0.8,'#fff'] //0.1透明度的白色背景
	});
	
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
			if(msg.info=="下一步"){
				window.location.href="../userController/showUserActive.action";
			}
			if(msg.info=="注册成功,请登录"){
				layer.msg(msg.info);
				setTimeout(function(){
					window.location.href="../userController/showUserLogin.action";
				},2000);
			}
			if(msg.info=="邮箱已经注册，请登录"){
				alert(msg.info);
				window.location.href="../userController/showUserLogin.action";
			}
			if(msg.info=="用户名被占用，请修改用户名"){
				alert(msg.info);
				window.location.reload();
			}
		},
		error: function () {
			alert("注册失败");
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

// 激活用户
function active(){
	
	$.ajax({
		type : 'POST',  
	    url : 'active.action',  
	    contentType: "application/json; charset=utf-8",   
	    data : $("#User").serializeArray(),
	    contentType: "application/x-www-form-urlencoded",  
		success: function(msg){
			if(msg.info=="激活成功"){
				alert("激活成功,请登录");
				window.location.href="../userController/showUserLogin.action";
			}else if(msg.info=="激活码失效，请重新注册"){
				alert("激活码失效，请重新注册");
				window.location.href="../userController/showUserRegister.action";
			}else if(msg.info=="激活码为空"){
				alert("激活码为空,请输入激活码");
			}else{
				alert("激活失败")
			}
		},
		error: function () {
			alert("注册失败");
		}
	});
}

function validator() {
	var userName = document.getElementById("userName").value;
	if(!validateAccount(userName)){
		return false;
	}
	
	var email = document.getElementById("email").value;
	if(!validateEmail(email)){
		return false;
	}
	
	var password = document.getElementById("password").value;
	if(!validatePassword(password)){
		return false;
	}
	var repassword = document.getElementById("repassword").value;
	if(!validatePassword(repassword)){
		return false;
	}
	if (password != repassword) {
		alert("两次输入的密码不一致");
		return false;
	}
	
	return true;
}