<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br><br><br>
<center><h1><font color="green">Car Booking System</font></h1></center>
<center><h3><font color="green">Login Form</font></h3></center>

<form:form action="handle-login" method="post" modelAttribute="User">
<table align="center">

	<tr>
		<td><label for="em">Enter Email</label></td>
		<td><form:input id="em" path="email"/></td>
		<td><form:errors path="email"/></td>
		
	</tr>
	<tr>
		<td><label for="pw">Enter password</label></td>
		<td><form:password path="password"/></td>
		<td><form:errors path="password"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
		
	</tr>
	</table>
</form:form>


</body>
</html>