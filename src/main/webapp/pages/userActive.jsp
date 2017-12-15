<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 激活</title>
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
		
		<c:if test="${email=='' or email==null }">
			页面失效，请返回
		</c:if>
		
		<c:if test="${email!='' and email!=null }">
			<form id="User" action="" method="post">
				<input style="display: none;" name="email" value="${email }">
				<div class="div1">
					激活码已经发送到您的邮箱"${email }"
					请输入激活码
				</div>
				
				<div class="div1">
					<label class="label1">激活码：</label>
					<input class="input2" type="text" name="activationCode" placeholder="请输入激活码" maxlength="6" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" >
				</div>
				
				<div class="div1">
					<button type="button" class="btn1" onclick="active()">激活</button>
				</div>
			</form>
		</c:if>
	</div>


</body>
</html>