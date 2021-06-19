<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<h1 align="center">Enter user Details</h1>
	<br>
	<br>

<form:form action="handle-add-user" method="post" modelAttribute="user">
	
		<table align="center">
			<tr>
				<td>Email Id</td>
					<td><form:input id="em" path="email"/></td>
					<td><form:errors path="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
					<td><form:password path="password"/></td>
					<td><form:errors path="password"/></td>	</tr>
			<tr>
				<td>Name</td>
					<td><form:input id ="Name" path="name"/></td>
		<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary">Add</button>
				</td>
				<td><a href="/welcome"
					class="btn btn-outline-danger"> Back</a></td>
			</tr>
		</table>
	</form:form>


	<c:if test="${not empty res }">
		<center><font color="green"><c:out value="${res }" /></font></center>
	</c:if>
</body>
</html>