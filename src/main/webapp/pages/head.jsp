<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2 T</title>
<link href="../res/css/frame.css" rel="stylesheet">
<script src="../res/js/user.logout.js"></script>
<!-- 可折叠菜单的引入 -->
<link rel=stylesheet type=text/css href="../res/foldingMenu/css/lrtk.css">
<script type=text/javascript src="../res/foldingMenu/js/jquery.min.js"></script>
<script src="../res/layer/layer.js"></script>
</head>

<body>
	<div class="row">
		<ol class="breadcrumb title">
			<li class="li-style">
				<span class="title-text">Account Book</span>
				<span class="userInfo">${session_user_key.userName}</span>
				
				<a class="logoutLink" href="#" onClick="logout()">注销</a>
			</li>
		</ol>
	</div>
</body>

</html>