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

<h1>
			<font color="green" ><center>ALL Users Infromation </center></font>
		</h1>
		<c:if test="${empty listUser }">
		<font color="red"><c:out value="!!!!No Record found"></c:out></font>
		</c:if>
		<c:if test="${not empty listUser }">
			<div class="viewport">
				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>Email ID</th>
						<th>Password</th>
						<th>Name</th>
						<th>Type of user</th>
					</tr>
					<c:forEach items="${listUser}" var="res">
						<tr>
							<td>UID0X1015U<c:out value="${res.id}" /></td>
							<td><c:out value="${res.email}" /></td>
							<td><c:out value="${res.password}" /></td>
							<td><c:out value="${res.name}" /></td>
							<td>
							<c:choose>
         
         					<c:when test = "${res.type==1}">
           						<c:out value="Admin" />
         						</c:when>
         					
         					
         					<c:when test = "${res.type==2}">
           						<c:out value="User" />
         					</c:when>
         					</c:choose>
							</td>
			
							<td><a href="deleteuser/${res.id}" class="btn btn-outline-danger">Delete</a></td>
							<td><a href="updateuser/${res.id}" class="btn btn btn-primary">update</a></td>
					
						</tr>
					</c:forEach>
				</table>
				<h3 align="center"><a href="/welcome"
					class="btn btn-outline-danger"> Back</a></h3>
				
			</div>
		</c:if>
		
				

</body>
</html>