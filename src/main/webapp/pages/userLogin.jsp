<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 登录</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/user.register.css" rel="stylesheet">
<script src="../res/js/user.login.js"></script>

</head>
<body>

	<!-- 头 -->
	<div class="container-fluid padding-top15">
		<div class="row">
			<div class="col-xs-12">
				<ol class="breadcrumb title">
					<li class="title-li"><span class="title-text">Account Book</span></li>
				</ol>
			</div>
		</div>
	</div>

	<div class="register">
		<div class="div1">
			<label class="label1">帐号/邮箱：</label>
			<input class="input1" id="account" placeholder="帐号/邮箱">
		</div>
		
		<div class="div1">
			<label class="label1">登录密码：</label>
			<input class="input1" type="password" id="password" placeholder="密码长度6-16位字符，由数字、字母组成">
		</div>
		
		<div class="div1">
			<label class="label1">验证码：</label>
			<input class="input2" type="text" id="checkCode" placeholder="请输入验证码">
			<a onclick="refreshCheckCodeButton()" href="#" id="refreshCheckCode"><img src="checkCode.action"></a>
		</div>
		
		<div class="div1">
			<label class="label1">记住我：</label>
			<input type="checkBox" id="rememberMe">
		</div>
		
		<div class="div1">
			<button class="btn1" onclick="login()">登录</button>
			<a href="showUserRegister.action" class="link1">注册</a>
		</div>
	</div>

</body>
</html>