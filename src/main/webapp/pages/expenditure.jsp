
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2 支出</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/inOrOut.css" rel="stylesheet">
<script src="../res/js/expenditure.js"></script>
<script src="../res/js/monthlyStatistics.js"></script>
<script src="../res/js/common/common.js"></script>
</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>

<div class="col-xs-10">
	<div class="col-xs-5">
		<div class="add">
			<label class="add-label">添加支出:</label><br>
			
			<div class="addIncome_div1">
				<label class="label2">日期：</label>
				<input class="Wdate add-data" type="text" onClick="WdatePicker()" id="date">
			</div><br>
			
			<div class="addIncome_div1"><label class="label2">项目：</label>
				<select class="add-select" id="item">
				    <c:forEach items="${items}" var="item">
		                 <option value=${item.id }>${item.name}</option>
		      		</c:forEach>
				</select>
			</div><br>

			<div class="addIncome_div1"><label class="label2">支出方式：</label>
				<select class="add-select" id="money-type">
		             <c:forEach items="${payMethods}" var="payMethod">
		                 <option value=${payMethod.id }>${payMethod.name}</option>
		      		 </c:forEach>
				</select>
			</div><br>
			
			<div class="addIncome_div1">
				<label class="label2">金额：</label>
				<input class="add-money" placeholder="金额" id="money">
			</div><br>
			
			<div class="addIncome_div2">
				<label class="label2">备注：</label>
				<textarea class="add-money-remark" placeholder="备注" id="remarkForExpenditure"></textarea>
			</div><br>
			
			<div class="addIncome_div1">
				<button class="add-button" onclick="addMoney()">添加</button>
			</div><br>
		</div>
		</div>
		<div class="col-xs-6">
		<br>
		<div class="div3"> 
			<label class="label4">月收入：</label>
			<label>${totalIncome}</label>
		</div>
		
		<div class="div3"> 
			<label class="label4">月支出：</label>
			<label>${totalExpenditure}</label>
		</div>
		
		<div class="div3">
			<label class="label4">非本月实际支出：</label>
			<label>${notActualExpenditure}</label>
		</div>
		
		<div class="div3">
			<label class="label4">本月实际支出：</label>
			<label>${actualExpenditure}</label>
		</div><br>
		
		<div class="div3">
			<label class="label4">本月初/上月末结余：</label>
			<label>${balanceInBeginOfMonth}</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="changeBalance('last', ${balanceInBeginOfMonth}, ${balanceId_InBeginOfMonth})">修改</button>
		</div>
		
		<div class="div3">
			<label class="label4">本月应结余：</label>
			<label>${balanceShould}</label>
		</div>
		
		<div class="div3">
			<label class="label4">本月实际结余：</label>
			<input class="input2" placeholder="月末输入" id="actual_balance">&nbsp;&nbsp;
			<button onclick="submitBalance()" id="submitBalanceButton">提交</button>
			<button onclick="changeBalance('this', ${actualBalance}, ${actualBalanceId})">修改</button>
		</div>
	</div>
</div>

<div class="col-xs-10">
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
					<th class="col1">日期</th>
					<th class="col2">项目</th>
					<th class="col3">金额</th>
					<th class="col4">收入方式</th>
					<th class="col5">备注</th>
					<th class="col6">操作</th>
		        </tr> 
		    </thead> 
		    <tbody> 
		        <c:forEach items="${expenditures}" var="expenditure">
                <tr>
                    <td><fmt:formatDate value="${expenditure.date}" pattern="yyyy-MM-dd"/></td> 
                    <td>${expenditure.itemName }</td>
                    <td>${expenditure.money }</td>
                    <td>${expenditure.payMethodName }</td>
                    <td>${expenditure.remark }</td>
                    <td><a href="#" onClick="changeExpenditure('${expenditure.id}','<fmt:formatDate value="${expenditure.date}" pattern="yyyy-MM-dd"/>','${expenditure.money }',${expenditure.itemId },'${expenditure.remark }','${expenditure.type_of_money }')">修改</a> 
                    	&nbsp;
                    	<a href="#" onClick="delExpenditure('${expenditure.id}')">删除</a></td>
                </tr>
          		</c:forEach>
		    </tbody> 
		</table>
	</div>
</div>
<%@ include file="common/bottom.jsp"%>

<!-- 修改支出弹出框 -->
<div id="addContent" class="hidden">
	<div class="addIncome_div1">
		<label class="label2">日期：</label>
		<input class="Wdate add-data" type="text" onClick="WdatePicker()" id="changedDate">
	</div><br>
	
	<div class="addIncome_div1">
		<label class="label2">项目：</label>
		<select class="add-select" id="changedItem">
		    <c:forEach items="${items}" var="item">
                 <option value=${item.id }>${item.name}</option>
      		</c:forEach>
		</select>
	</div><br>

	<div class="addIncome_div1">
		<label class="label2">支出方式：</label>
		<select class="add-select" id="changed-money-type">
			 <c:forEach items="${payMethods}" var="payMethod">
                 <option value=${payMethod.id }>${payMethod.name}</option>
      		 </c:forEach>
		</select>
	</div><br>
	
	<div class="addIncome_div1">
		<label class="label2">金额：</label>
		<input class="add-money" id="changedMoney">
	</div><br>
	
	<div class="addIncome_div2">
		<label class="label2">备注：</label>
		<textarea class="add-money-remark" id="changedRemark"></textarea>
	</div><br>
</div>

<!--  修改结余金额 弹出框  -->
<div id="changeBalance" class="hidden">
	<div><label id="month_label"></label></div><br>
	<div class="addIncome_div1">
		<label class="label5">金额：</label>
		<input class="input2" id="changed_balance">
	</div><br>
</div>

<script language="JavaScript" type="text/JavaScript"> 
	document.onload = fillUpDate();
	document.onload = unenableInput('${actualBalance}');
</script>
