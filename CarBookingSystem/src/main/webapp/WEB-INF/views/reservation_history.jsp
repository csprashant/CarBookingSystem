<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<h1>
		<font color="green"><center>ALL Reservation
				Infromation</center></font>
	</h1>
	<c:if test="${empty listreservation }">
		<font color="red"><c:out value="!!!!No Record found"></c:out></font>
	</c:if>
	<c:if test="${not empty listreservation }">
		<div class="viewport">
			<table class="table table-striped" border="2" bordercolor="black" align="center">
				<tr>
					<th>Reservation ID</th>
					<th>UserID</th>
					<th>User Name</th>
					<th>Vehicle ID</th>
					<th>Vehicle Name</th>
					<th>Vehicle Number</th>
					<th>From Date<br>(YYYY-MM-DD)</th>
					<th>To Date<br>(YYYY-MM-DD)</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${listreservation}" var="res">
					<tr>
						<td>RID0X1016R<c:out value="${res.id}" /></td>
						<td>UID0X1015U<c:out value="${res.userId}" /></td>
						<td><c:out value="${res.userName}" /></td>
						<td>VIDX0102B<c:out value="${res.vehicleId}" /></td>
						<td align="center"><c:out value="${res.VName}" /></td>
						<td align="center"><c:out value="${res.VNumber}" /></td>
						<td align="center"><c:out value="${res.fromDate}" /></td>
						<td align="center"><c:out value="${res.toDate}" /></td>
						<td><c:choose>
								<c:when test="${res.status==true}">
									<c:out value="Booked" />
								</c:when>
								<c:when test="${res.status==false}">
									<c:out value="Free" />
								</c:when>
							</c:choose>
					</tr>
				</c:forEach>
			</table>
			<h3 align="center">
				<a href="/welcome" class="btn btn-outline-danger">
					Back</a>
			</h3>
		</div>
	</c:if>



</body>
</html>