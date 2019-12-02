<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--     <jsp:useBean id="user" class="model.user"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is the first time to use SpringMVC</h1>
	<br />
	<h2>Login</h2>
	<form action="Index" method="post">
		用户名： <input type="text" name="username" /> <br /> 密码： <input
			type="password" name="password" /> <br /> <input type="submit"
			value="验证" />
	</form>

	<a href="Register">no amount? register right now</a>


	<h1>We use Github first time !!!!!!19:21</h1>

	<h1>we use it second!!!!</h1>
	asdsadsadsad

	<table id="tableUserData">
		<tr>
			<th>用户名</th>
			<th>密码</th>

		</tr>

		<c:forEach items="${userDataList }" var="model">
			<tr>
				<td>${model.username }</td>
				<td>${model.password }</td>
			</tr>
		</c:forEach>

	</table>






</body>
</html>