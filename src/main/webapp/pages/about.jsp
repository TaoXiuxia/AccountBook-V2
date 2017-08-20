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
</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>

<div class="col-xs-10">
	
	<label>项目管理：</label>上移与下移功能<br>
	<label>分用户分账本：</label><br>
	<label>收入，支出加分页：</label><br>
	<label>收入支出 方式：</label>应该有一个单独的页面，与项目管理类似的
	
</div>
<%@ include file="common/bottom.jsp"%>