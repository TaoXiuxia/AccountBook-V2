<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2</title>
</head>

<frameset rows="55px,90%" frameborder="no">
	<frame src="../frameController/head" />
	<frameset cols="240px,85%" frameborder="no">
		<frame src="../frameController/menu" />
		<frame id="main_content" src="../expenditureController/showExpenditure" />
	</frameset>
</frameset>

</html>