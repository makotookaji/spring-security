<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<h3>You have been logged in.</h3>
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<h3>Login Form</h3>
		<c:url value="/login" var="loginUrl" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<span style="color: red;">Invalid username and password.</span>
			</c:if>
			<p>
				<label for="username">Username</label> <input type="text"
					id="username" name="username" />
			</p>
			<p>
				<label for="password">Password</label> <input type="password"
					id="password" name="password" />
			</p>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn">Log in</button>
		</form>
	</sec:authorize>
</body>
</html>