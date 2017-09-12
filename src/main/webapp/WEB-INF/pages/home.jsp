<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home page</title>
<style>
#home-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="home-box">
		<h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
		
		<strong>Your roles are:</strong>
		<ul>		
			<c:forEach items="${user.userRoles}" var="role">
				<li>${role.name}</li>
			</c:forEach>
		</ul>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>
</body>
</html>