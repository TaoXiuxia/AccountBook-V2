<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ABV2 收支方式管理</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/managePayMethods.css" rel="stylesheet">
<script src="../res/js/managePayMethods.js"></script>
<script src="../res/js/common/common.js"></script>
</head>
<body>
<div class="container-fluid padding-top15">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb navigation">
				<li class="navi-li">
					<span class="navi-text">管理 > 收支方式管理</span>
				</li>
			</ol>
		</div>
		
		<div class="col-xs-12">
			<div class="total"> 
				<label class="total-label1"><span class="tableTitle">收入方式</span></label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="add-button" onclick="addPayMethod('in')">添加收入方式</button>
			</div>
			<div>
				<table class="table table-bordered"> 
				    <thead> 
				        <tr> 
							<th class="col1">收入方式</th>
							<th class="col2">备注</th>
							<th class="col3">操作</th>
							<th class="col4">排序</th>
				        </tr>
				    </thead>
				    <tbody> 
				        <c:forEach items="${incomePayMethods}" var="incomePayMethod">
		                <tr>
		                    <td>${incomePayMethod.name }</td>
		                    <td>${incomePayMethod.remark }</td>
		                    <td>
		                    	<a href="#" onClick="changePayMethod('${incomePayMethod.id}','${incomePayMethod.name }','','${incomePayMethod.remark }','in')">修改</a> 
		                    	&nbsp;&nbsp;
		                    	<a href="#" onClick="delPayMethod('${incomePayMethod.id}')">删除</a>
		                    </td>
		                    <td>
		                    	<a href="#" onClick="upAndDown('payMethod','in','${incomePayMethod.id}','up')">上移</a>
			                    &nbsp;&nbsp;
			                    <a href="#" onClick="upAndDown('payMethod','in','${incomePayMethod.id}','down')">下移</a>
		                    </td>
		                </tr>
		          		</c:forEach>
				    </tbody> 
				</table>
			</div>
			<br>
			<div class="total"> 
				<label class="total-label1"><span class="tableTitle">支出方式</span></label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="add-button" onclick="addPayMethod('ex')">添加支出方式</button>
			</div>
			<div>
				<table class="table table-bordered"> 
				    <thead> 
				        <tr> 
							<th class="col1">支出方式</th>
							<th class="col1">是否计入本月支出</th>
							<th class="col2">备注</th>
							<th class="col3">操作</th>
							<th class="col4">排序</th>
				        </tr>
				    </thead>
				    <tbody> 
				        <c:forEach items="${expenditurePayMethods}" var="expenditurePayMethod">
			                <tr>
			                    <td>${expenditurePayMethod.name }</td>
			                    <td>
			                    	<c:if test="${expenditurePayMethod.isCountInThisMonthEx == '1'}">是</c:if>
			                    	<c:if test="${expenditurePayMethod.isCountInThisMonthEx == '0'}">否</c:if>
			                    </td>
			                    <td>${expenditurePayMethod.remark }</td>
			                    <td>
			                    	<a href="#" onClick="changePayMethod('${expenditurePayMethod.id}','${expenditurePayMethod.name }','${expenditurePayMethod.isCountInThisMonthEx }','${expenditurePayMethod.remark }','ex')">修改</a> 
			                    	&nbsp;&nbsp;
			                    	<a href="#" onClick="delPayMethod('${expenditurePayMethod.id}')">删除</a>
			                    </td>
			                    <td>
			                    	<a href="#" onClick="upAndDown('payMethod','ex','${expenditurePayMethod.id}','up')">上移</a>
			                    	&nbsp;&nbsp;
			                    	<a href="#" onClick="upAndDown('payMethod','ex','${expenditurePayMethod.id}','down')">下移</a>
			               		</td>
			                </tr>
		          		</c:forEach>
				    </tbody> 
				</table>
			</div>
		</div>
	</div>
</div>




<div id="addPayMethodLayer" class="hidden">
 您确定要修改吗？<br>
 如果修改，将同时修改已添加收入/支出的收支方式!<br>
     如果不想改变现有数据，<br>
    可以删除本收支方式，添加新收支方式！
    <div class="addPayMethod">
        <label class="addPayMethod-label">收支方式：&nbsp;&nbsp;</label>
        <input type="text" id="addedPayMethodName" placeholder="收支方式" >
    </div>
    <div id="isCountInThisMonthExDiv">
        <label class="addPayMethod-label">是否计入本月收支：&nbsp;&nbsp;</label>
        <select class="add-select" id="added_isCountInThisMonthEx">
        	<option value="1">是</option>
        	<option value="0">否</option>
        </select>
    </div>
	<div>
        <label class="addPayMethod-label">备注：&nbsp;&nbsp;</label>
        <input type="text" id="addedPayMethodRemark" placeholder="备注" >
	</div>
</div>

</body>
</html>
