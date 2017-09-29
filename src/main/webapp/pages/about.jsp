<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2 收入</title>
<%@ include file="common/common.jsp" %> 
<script src="../res/js/about.js"></script>
<link href="../res/css/about.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid padding-top15">
	<div class="row">
		<script language="JavaScript" type="text/JavaScript"> 
			document.onload = setLeftColumn();
		</script>
		
		<div class="col-xs-10">
			<div class="col-xs-10 label1">一毛钱，您买不了吃亏，一毛钱，您也买不了上当</div>
			<br><br>
			<div class="col-xs-5 label1">
				<img class="money-image" src="../images/wechat0.1.png"/>
			</div>
			<div class="col-xs-5 label1">
				<img class="money-image" src="../images/alipay0.1.png"/>
			</div>
		
			<div class="col-xs-10 label2">您老随意</div>
			<div class="col-xs-5 label1">
				<img class="money-image" src="../images/wechat.png"/>
			</div>
			<div class="col-xs-5 label1">
				<img class="money-image" src="../images/alipay.png"/>
			</div>
		</div>
	</div>
</div>
</body>
</html>