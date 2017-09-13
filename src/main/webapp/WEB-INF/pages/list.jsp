<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<style>
#list-box {
	width: 500px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
table, td, th {
  border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="list-box">
		<h2>List of Users</h2>
		<table style="width: 100%">
			<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Username</th>
					<th>Roles</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.userName}</td>
						<td>
							<c:forEach items="${user.userRoles}" var="role">
								${role.name}
							</c:forEach>
						</td>
						<td><a href="delete?userId=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>		
	</div>
</body>
</html>