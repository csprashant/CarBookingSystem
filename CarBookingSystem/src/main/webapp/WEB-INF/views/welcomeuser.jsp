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
<br><br><br>
<p><font color="green"><h4 align="center">Welcome  ${user.name }</h4></font></P>
<nav><center>
||<a href="/list-all-vehicle-user" >List All Vehicle</a>
||<a href="logout" >Logout</a>||&nbsp;&nbsp;&nbsp;</center>
<!-- ||<a href="reservation-status" >Reservation Status</a>||&nbsp;&nbsp;&nbsp;</center>-->
 
</nav>
<c:if test="${not empty msg }">
		<center><font color="green"><c:out value="${msg}" /></font></center>
	</c:if>
</body>
</html>