<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mypage</title>
</head>
<body>
	<table border="0" cellspacing="0" cellpadding="0" align="left">
		<tr>
			<td>UserName : </td>
			<td>${username}</td>
		</tr>
		<tr>
			<td>RealName : </td>
			<td>${realname}</td>
		</tr>
		<tr>
			<td>Authorities : </td>
			<td>${authorities}</td>
		</tr>
		<tr>
			<td>Address : </td>
			<td>${address}</td>
		</tr>
		<tr>
			<td>Gender : </td>
			<td>${gender}</td>
		</tr>
		<tr>
			<td><a href="/welcome">back to Welcome page</a></td>
			<td><c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" method="post">
					<input type="submit" value="Log out" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form></td>
		</tr>
	</table>



</body>
</html>