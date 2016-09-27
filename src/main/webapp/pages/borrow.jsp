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
	<div>
		<label class="add-label">借入:</label>
		<input class="add-money" placeholder="金额">
		<button class="add-button">添加</button>
	</div>
	
	<div class="add">
		<label class="add-label">借出:</label>
		<input class="add-money" placeholder="金额">
		<button class="add-button">添加</button>
	</div>
			
	<div class="total"> 
		<label class="total-label1">月借入：</label>
		<label class="total-money1">3000元</label>
		
		<label class="total-label2">月借出：</label>
		<label class="total-money2">300元</label>
	</div>
	
	<div class="selectAndSearch">
		<select class="select">
			<option>全部</option>
			<option>借入</option>
			<option>借出</option>
		</select>
		
		<input class="searchInput" placeholder="搜索对象">
		<button class="add-button">搜索</button>
	</div>
	
	<div class="borrowTable">
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
		            <th>名称</th> 
		            <th>城市</th> 
		            <th>密码</th> 
		        </tr> 
		    </thead> 
		    <tbody> 
		        <tr> 
		            <td>Tanmay</td> 
		            <td>Bangalore</td> 
		            <td>560001</td> 
		        </tr> 
		        <tr> 
		            <td>Sachin</td> 
		            <td>Mumbai</td> 
		            <td>400003</td> 
		        </tr> 
		        <tr> 
		            <td>Uma</td> 
		            <td>Pune</td> 
		            <td>411027</td> 
		        </tr> 
		    </tbody> 
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>