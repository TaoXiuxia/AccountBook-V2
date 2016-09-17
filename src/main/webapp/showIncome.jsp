<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>person list</title>
</head>
<body>
	<table>
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>年龄</th>
			<th>年龄</th>
			<th>年龄</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${incomes}" var="income">
			<tr>
				<td>${income.incomeId }</td>
				<td>${income.incomeUserId }</td>
				<td>${income.incomeItemId }</td>
				<td>${income.incomeMoney }</td>
				<td>${income.incomeDate }</td>
				<td>${income.incomeRemark }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>