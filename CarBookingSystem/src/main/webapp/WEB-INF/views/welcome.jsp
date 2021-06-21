<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page 	errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br>
<p><font color="green"><h4 align="center">Welcome  ${user.name }</h4></font></P>
<h1 align ="center">
<nav>
||<a href="/add-user" >Add user</a>||&nbsp;&nbsp;&nbsp;
||<a href="/list-all-users" >List All Users</a>||&nbsp;&nbsp;&nbsp;
 ||<a href="/add-vehicle" >Add Vehicle</a>||&nbsp;&nbsp;&nbsp;
||<a href="/list-all-vehicle" >List All Vehicle</a>||&nbsp;&nbsp;&nbsp;
||<a href="/list-reservation-history" >ResrvatinoHistory</a>||&nbsp;&nbsp;&nbsp;
||<a href="/logout" >Logout</a>||&nbsp;&nbsp;&nbsp; 
</nav></h1>
</body>
</html>