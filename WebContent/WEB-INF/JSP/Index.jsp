<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--     <jsp:useBean id="user" class="model.user"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XXX系统首页</title>
    <link href="../Content/bootstrap.css" rel="stylesheet" />
    <script src="../Scripts/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../Scripts/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
    <script src="../Scripts/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>


	<h1>This is the first time to use SpringMVC</h1>
	<br />
	<h2>Login</h2>
	<form action="Index" method="post">
		用户名： <input type="text" name="username" />
		<br /> 
		密码：<input type="password" name="password" />
		<br /> 
		<input type="submit" value="登录" />
	</form>

	<a href="Register">没有账号？立即注册！</a>



</body>
</html>