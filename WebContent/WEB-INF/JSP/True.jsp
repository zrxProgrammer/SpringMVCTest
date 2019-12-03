<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>True</title>
</head>
<body>
 <h1>True!!</h1>
 
 	<table id="tableUserData">
		<tr>
			<th>用户名</th>
			<th>密码</th>
			<th>详情</th>
			<th>删除</th>
		</tr>

		<c:forEach items="${userDataList }" var="model">
			<tr>
				<td>${model.username }</td>
				<td>${model.password }</td>
				<td>
					<a href="Details?username=${model.username }">详情</a>
				</td>
				<td>
					<a href="Delete?username=${model.username }">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>
 
 <a href="UpdatePwd">更改密码</a>
 
 <a href="Index">返回首页</a>
 
 
 
 
 
</body>
</html>