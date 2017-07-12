<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 收入</title>
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
	<div class="col-xs-5">
		<div class="add">
			<label class="add-label">添加收入:</label><br>
			
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

			<div class="addIncome_div1"><label class="label2">收入方式：</label>
				<select class="add-select" id="money-type">
					 <option value=""></option>
		             <option value="支付宝">支付宝</option>
		             <option value="信用卡">信用卡</option>
		             <option value="微信">微信</option>
		             <option value="现金">现金</option>
		             <option value="银行卡">银行卡</option>
		             <option value="其他">其他</option>
				</select>
			</div><br>
			
			<div class="addIncome_div1">
				<label class="label2">金额：</label>
				<input class="add-money" placeholder="金额" id="money">
			</div><br>
			
			<div class="addIncome_div2">
				<label class="label2">备注：</label>
				<textarea class="add-money-remark" placeholder="备注" id="remarkForIncome"></textarea>
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
		</div><br>
		
		<div class="div3">
			<label class="label4">本月初/上月末结余：</label>
			<label>${balanceInBeginOfMonth}</label>
			<label class="label3">&nbsp;&nbsp;&nbsp;（未计入花呗与信用卡）</label>
			<button onclick="changeBalance('last')">修改</button>
		</div>
		
		<div class="div3">
			<label class="label4">本月应结余：</label>
			<label>${balanceShould}</label>
			<label class="label3">&nbsp;&nbsp;&nbsp;（花呗与信用卡不计入本月支出）</label>
		</div>
		
		<div class="div3">
			<label class="label4">本月实际结余：</label>
			<input class="input2" placeholder="月末输入" id="actualSurplus">&nbsp;&nbsp;
			<button onclick="xxxxx()">提交</button>
			<button onclick="yyyyy()">修改</button>
		</div>
	</div>
</div>
<div class="col-xs-10">
	
		
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
					<th>日期</th>
					<th>项目</th>
					<th>金额</th>
					<th>收入方式</th>
					<th>备注</th>
					<th>操作</th>
		        </tr> 
		    </thead> 
		    <tbody> 
		        <c:forEach items="${incomes}" var="income">
                <tr>
                    <td><fmt:formatDate value="${income.date}" pattern="yyyy-MM-dd"/></td> 
                    <td>${income.itemName }</td>
                    <td>${income.money }</td>
                    <td>${income.type_of_money }</td>
                    <td>${income.remark }</td>
                    <td><a href="#" onClick="changeIncome('${income.id}','<fmt:formatDate value="${income.date}" pattern="yyyy-MM-dd"/>','${income.money }','${income.itemId }','${income.remark }','${income.type_of_money }')">修改</a> 
                    	<a href="#" onClick="delIncome('${income.id}','${income.itemId}')">删除</a></td>
                </tr>
          		</c:forEach>
		    </tbody> 
		</table>
	</div>
</div>
<%@ include file="common/bottom.jsp"%>


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
		<label class="label2">收入方式：</label>
		<select class="add-select" id="changed-money-type">
			 <option value=""></option>
             <option value="支付宝">支付宝</option>
             <option value="信用卡">信用卡</option>
             <option value="微信">微信</option>
             <option value="现金">现金</option>
             <option value="银行卡">银行卡</option>
             <option value="其他">其他</option>
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

<!--    -->
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
