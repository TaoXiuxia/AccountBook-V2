<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book V2</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/inOrOut.css" rel="stylesheet">
<script src="../res/js/income.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-10">
	<div class="add">
		<label class="add-label">添加收入:</label>
		<select class="add-select" id="item">
			<option>1</option>
			<option>2</option>
			<option>3</option>
		</select>
		<input class="add-money" placeholder="金额" id="money">
		<input class="add-money-remark" placeholder="备注" id="remarkForIncome">
		<button class="add-button" onclick="addMoney()">添加</button>
	</div>
	
	<div class="addItem">
		<label class="addItem-label">添加收入项目:</label>
		<input class="addItem-name" placeholder="项目名称" id="itemName">
		<input class="addItem-remark" placeholder="备注" id="remarkForItem">
		<button class="addItem-button" onclick="addItem()">添加</button>
	</div>	
		
	<div class="total"> 
		<label class="total-label1">月收入：</label>
		<label class="total-money1">${totalIncome}</label>
		
		<label class="total-label2">日均收入：</label>
		<label class="total-money2">${averageIncome}元</label>
	</div>
		
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
					<th>日期</th>
					<th>Money</th>
					<th>项目</th>
					<th>备注</th>
		        </tr> 
		    </thead> 
		    <tbody> 
		        <c:forEach items="${incomes}" var="income">
                <tr>
                    <td>${income.date }</td>
                    <td>${income.money }</td>
                    <td>${income.name }</td>
                    <td>${income.remark }</td>
                </tr>
          		</c:forEach>
		    </tbody> 
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>