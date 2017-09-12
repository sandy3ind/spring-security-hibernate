<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<style>
#registration-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
.field-error {
	color: red;
}
</style>
</head>
<body>
	<div id="registration-box">
		<h2>Registration</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<form:form method="POST" modelAttribute="user" action="save">
			<table>
				<tr>
					<td>First Name</td>
					<td>
						<form:input type="text" path="firstName" id="firstName"/><br/>
						<form:errors path="firstName" class="field-error"/>
					</td>	
				</tr>
				<tr>
					<td>Last Name</td>
					<td>
						<form:input type="text" path="lastName" id="lastName"/><br/>
						<form:errors path="lastName" class="field-error"/>
					</td>	
				</tr>
				<tr>
					<td>Username</td>
					<td>
						<form:input type="text" path="userName" id="userName"/><br/>
						<form:errors path="userName" class="field-error"/>
					</td>	
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<form:input type="password" path="password" id="password"/><br/>
						<form:errors path="password" class="field-error"/>
					</td>	
				</tr>
				<tr>
					<td>Roles</td>
					<td>
						<form:checkboxes path="roles" items="${roles}" itemLabel="name" itemValue="id" /><br/>
						<form:errors path="roles" class="field-error"/>
					</td>	
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td>&nbsp;</td>	
				</tr>
			</table>
		</form:form>
		<a href="list">Users list</a>
	</div>
</body>
</html>