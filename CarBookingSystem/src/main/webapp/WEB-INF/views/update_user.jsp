<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page 	errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<br>
	<br>
	<h1 align="center">Update User Details</h1>
	<br>
	<br>

	<form action="/handle-update-user" method="post">
		<input type="hidden" name="id" value="${user.id }">
		<input type="hidden" name="type" value="${user.type }">
			<table align="center">
			<tr>
				<td>Email Id</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
				<td><c:if test="${not empty email }"><font color="red"><c:out value="${email}"></c:out></font></c:if></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${user.password}" /></td>
				<td><c:if test="${not empty password }"><font color="red"><c:out value="${password}"></c:out></font></c:if></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${user.name }"/></td>
				<td><c:if test="${not empty name }"><font color="red"><c:out value="${name}"></c:out></font></c:if></td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary">Update</button>
				</td>
				<td><a href="/welcome"
					class="btn btn-outline-danger"> Back</a></td>
			</tr>
		</table>
	</form>


	<c:if test="${not empty res }">
		<center><font color="green"><c:out value="${res }" /></font></center>
	</c:if>
</body>
</html>