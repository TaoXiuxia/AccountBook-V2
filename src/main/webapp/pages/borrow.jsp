<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/borrow.css" rel="stylesheet">
<script src="../res/js/borrow.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>

<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>

<div class="col-xs-10">
	还没有想好做什么	
</div>
<%@ include file="common/bottom.jsp"%>