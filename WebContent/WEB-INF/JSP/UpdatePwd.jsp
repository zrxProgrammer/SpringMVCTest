<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdatePwd" method="post">
		原密码： <input type="text" name="OldPassword" />
		<br /> 
		新密码：<input type="password" name="NewPassword" />
		<br /> 
		重复密码：<input type="password" name="ReNewPassword" />
		
		<input type="submit" value="更改" />
	</form>

</body>
</html>