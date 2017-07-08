<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 支出</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/inOrOut.css" rel="stylesheet">
<script src="../res/js/expenditure.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-10">
	<div class="add">
		<label class="add-label">添加支出:</label>
		<select class="add-select" id="item">
		    <c:forEach items="${items}" var="item">
                 <option value=${item.id }>${item.name}</option>
      		</c:forEach>
		</select>
		<input class="add-money" placeholder="金额" id="money">
		<input class="add-money-remark" placeholder="备注" id="remarkForExpenditure">
		<button class="add-button" onclick="addMoney()">添加</button>
	</div>
	
	<div class="total"> 
		<label class="total-label1">月支出：</label>
		<label class="total-money1">${totalExpenditure}</label>
		
		<label class="total-label2">日均支出：</label>
		<label class="total-money2">${averageExpenditure}元</label>
	</div>
		
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
					<th>日期</th>
					<th>Money</th>
					<th>项目</th>
					<th>备注</th>
					<th>操作</th>
		        </tr> 
		    </thead> 
		    <tbody> 
		        <c:forEach items="${expenditures}" var="expenditure">
                <tr>
                    <td><fmt:formatDate value="${expenditure.date}" pattern="yyyy-MM-dd"/></td> 
                    <td>${expenditure.money }</td>
                    <td>${expenditure.itemName }</td>
                    <td>${expenditure.remark }</td>
                    <td><a href="#" onClick="changeExpenditure('${expenditure.id}','<fmt:formatDate value="${expenditure.date}" pattern="yyyy-MM-dd"/>','${expenditure.money }',${expenditure.itemId },'${expenditure.remark }')">修改</a> 
                    	<a href="#" onClick="delExpenditure('${expenditure.id}','${expenditure.itemId}')">删除</a></td>
                </tr>
          		</c:forEach>
		    </tbody> 
		</table>
	</div>
</div>
<%@ include file="common/bottom.jsp"%>


<div id="addContent" class="hidden">
    
    <div class="change">
        <label class="changeLabel">日期</label>
        <input type="text" id="changedDate" placeholder="日期" >
    </div>
    <div class="change">
        <label class="changeLabel">Money</label>
        <input type="text" id="changedMoney" placeholder="Money" >
    </div>
    <div>
        <label class="changeLabel">项目</label>
        <select class="add-select" id="changedItem">
  		<c:forEach items="${items}" var="item">
             <option value=${item.id }>${item.name}</option>
  		</c:forEach>
		</select>
	</div>
	<div>
        <label class="changeLabel">备注</label>
        <input type="text" id="changedRemark" placeholder="备注" >
	</div>
</div>

