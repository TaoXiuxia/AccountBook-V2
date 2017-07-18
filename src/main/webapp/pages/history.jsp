<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2 往月收支</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/history.css" rel="stylesheet">
<script src="../res/js/history.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-10">

	<div> 
		<label class="label2">类目</label>
		<select class="select1" id="type">
        	<option value="all">全部</option>
        	<option value="in">收入</option>
        	<option value="ex">支出</option>
		</select>
	
		<label class="label2">&nbsp;&nbsp;&nbsp;年&nbsp;</label>
		<select class="select1" id="year">
			<option value="-1">全部</option>
        	<option value="2015">2015</option>
        	<option value="2016">2016</option>
		</select>
		
		<label class="label2">&nbsp;&nbsp;&nbsp;月&nbsp;</label>
		<select class="select1" id="month">
			<option value="-1">全部</option>	
        	<option value="01">01</option>
        	<option value="02">02</option>
        	<option value="03">03</option>
        	<option value="04">04</option>
        	<option value="05">05</option>
        	<option value="06">06</option>
        	<option value="07">07</option>
        	<option value="08">08</option>
        	<option value="09">09</option>
        	<option value="10">10</option>
        	<option value="11">11</option>
        	<option value="12">12</option>
		</select>
		
		<label class="label2">&nbsp;&nbsp;&nbsp;关键词&nbsp;</label>
		<input class="input1" placeholder="金额/项目/备注" id="keyword">
		
		<label class="label2">&nbsp;&nbsp;&nbsp;排序方式&nbsp;</label>
		<select class="select1" id="sortBy">
			<option value="dateDESC">日期降序</option>	
        	<option value="dateASC">日期升序</option>
        	<option value="moneyDESC">金额降序</option>
        	<option value="moneyASC">金额升序</option>
		</select>
		
		&nbsp;&nbsp;&nbsp;
		<button onclick="search()">筛选</button>
	</div>
	<br>
	<div>
		<table class="table table-bordered" id="details"> 
		    <thead> 
		        <tr> 
					<th>日期</th>
					<th>金额</th>
					<th>类型</th>
					<th>项目</th>
					<th>备注</th>
					<th>操作</th>
		        </tr>
		    </thead>
		    <tbody id="detailItems"> 
		        <c:forEach items="${historys}" var="history">
                <tr>
                    <td><fmt:formatDate value="${history.date}" pattern="yyyy-MM-dd"/></td>
                    <td>${history.money }</td>
                    <td><c:if test="${history.itemType =='in'}">收入</c:if><c:if test="${history.itemType =='ex'}">支出</c:if></td>
                    <td>${history.itemName }</td>
                    <td>${history.remark }</td>
                    <td><a href="#" onClick="changeDetailsItem(
                    								'${history.itemType}',
                    								'${history.id }',
                    								'${history.date}',
                    								'${history.money}',
                    								'${history.itemId}',
                    								'${history.remark}'
                    								)">修改</a> 
                    	&nbsp;
                    	<a href="#" onClick="delDetailsItem(
						                    		'${history.itemType}',
													'${history.id }',
													'${history.itemId}'
						                    		)">删除</a></td>
                </tr>
          		</c:forEach>
		    </tbody> 
		</table>
	</div>

</div>
<%@ include file="common/bottom.jsp"%>


<!-- 修改命令的弹出框 -->
<div id="changeDetailsItemLayer" class="hidden">
    <div class="layout_div_Style">
        <label class="change-label">日期</label>
        <input class="change-text" type="text" id="changedDate" placeholder="日期" >
    </div>
	<div class="layout_div_Style">
        <label class="change-label">金额</label>
        <input class="change-text" type="text" id="changedMoney" placeholder="Money" >
	</div>
	<div class="layout_div_Style">
        <label class="change-label">类型</label>
        <select class="change-text" id="changedType" onchange="changeType1()">
        	<option value="in">收入</option>
        	<option value="ex">支出</option>
		</select>
	</div>
	<div class="layout_div_Style" id="changedItemDiv">
        <label class="change-label">项目</label>
        <select class="change-text" id="changedItem">
		    <c:forEach items="${incomesItems}" var="item">
                 <option class="in" value=${item.id }>${item.name}</option>
      		</c:forEach>
      		<c:forEach items="${expenditureItems}" var="item">
                 <option class="ex" value=${item.id }>${item.name}</option>
      		</c:forEach>
		</select>
	</div>
	<div class="layout_div_Style">
        <label class="change-label">备注</label>
        <input class="change-text" type="text" id="changedRemark" placeholder="备注" >
	</div>
</div>
<!-- / -->
