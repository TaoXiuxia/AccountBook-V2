<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 注册</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/user.register.css" rel="stylesheet">
<script src="../res/js/user.register.js"></script>

</head>
<body>
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
			<label class="label1">帐号：</label>
			<input class="input1" id="userName" name="userName" placeholder="长度1-12位，由数字、字母组成"  maxlength="12"> 
		</div>
		<div class="div1">
			<label class="label1">邮箱：</label>
			<input class="input1" id="email" placeholder="请填写正确的常用邮箱">
		</div>
		<div class="div1">
			<label class="label1">登录密码：</label>
			<input class="input1" type="password" id="password" placeholder="长度6-12位，由数字、字母组成"  maxlength="12">
		</div>
		<div class="div1">
			<label class="label1">确认登录密码：</label>
			<input class="input1" type="password" id="repassword" placeholder="请再次输入密码"  maxlength="12">
		</div>
		<div class="div1">
			<button class="btn1" onclick="register()">下一步</button>
			<a href="showUserLogin.action" class="link1">已有账号，登录</a>
		</div>
	</div>


</body>
</html>