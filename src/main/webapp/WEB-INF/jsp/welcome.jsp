<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h3>Welcome!!</h3>
	<br>
	<sec:authorize access="hasAnyRole('USER','ADMIN')">
		<a href="/user">Here is User Page!!</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="/admin">Here is Admin Page!!</a>
	</sec:authorize>

	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>