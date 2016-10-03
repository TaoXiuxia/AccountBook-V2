<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book V2</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/monthlyStatistics.css" rel="stylesheet">
<script src="../res/js/monthlyStatistics.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-7 left">
	<div class="head">
		<label class="label1">本月收入：</label>
		<label class="money1">${monthlyIncome}</label>
		<label class="label1">日均收入：</label>
		<label class="money1">${averageIncome}</label>
	</div>
	<div class="head2">
		<label class="label1">本月支出：</label>
		<label class="money1">${monthlyExpenditure}</label>
		<label class="label1">日均支出：</label>
		<label class="money1">${averageExpenditure}</label>
	</div>
	<div class="head">
		<label class="label1">月初结余：</label>
		<label class="money1">${balanceInBeginOfMonth}</label>
	</div>
	<div class="head2">
		<c:if test="${isLastDay!=true}">
			<label class="label1">今日应结余：</label>
		</c:if>
		<c:if test="${isLastDay==true}">
			<label class="label1">月末应结余：</label>
		</c:if>
		<label class="money1">${balanceShould}</label>
	</div>
	
	<c:if test="${isLastDay==true}">
		<div class="head2">
			<label class="label1">月末实结余：</label>
			<c:if test="${balanceOfThisMonth.actualBalance==null}">
				<input class="money1" placeholder="月末实结余" id="actualBalance">
				<button class="button1" onclick="addMoney()">添加</button>
			</c:if>
			<c:if test="${balanceOfThisMonth.actualBalance!=null}">
				<input class="hidden" value="${balanceOfThisMonth.id}" id="balanceId"/>
				<input class="money1" value="${balanceOfThisMonth.actualBalance}" id="actualBalance">
				<button class="button1" onclick="changeMoney()">修改</button>
			</c:if>
		</div>
	</c:if>
	
	<div class="head">
		<c:if test="${isLastDay==true}">
			<button class="button2" onclick="toExcel()">导出本月数据到excel</button>
		</c:if>
	</div>
	
</div>
<%@ include file="common/bottom.jsp"%>
