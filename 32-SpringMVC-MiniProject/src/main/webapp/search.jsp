<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>|||Update Data|||</title>
<style type="text/css">
.error{
 color: red;
}
</style>
</head>
<body>
	<div align="center">
		<br /> <br /> <br />
		<h1>Update student Form</h1>
		<h2 style="color: green;">${requestScope.status}</h2>
		<form:form action="search" method="POST" modelAttribute="student">
			<table>
				<tr>
					<td>Sid:</td>
					<td><form:input path="sid" /></td>
					<td><form:errors path="sid" cssClass="error" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><a href="curdIndex.jsp">Goto Curd Index</a></td>
				</tr>
			</table>
		</form:form>
		<%if(request.getAttribute("studentBySid")!=null){  %>
		<br /> <br /> <br />
		<table style="border-color: black;">
		<tr>
		<td>sid:</td>
		<td>${studentBySid.sid}</td>
		</tr>
		<tr>
		<td>Name:</td>
		<td>${studentBySid.name}</td>
		</tr>
		<tr>
		<td>Surname:</td>
		<td>${studentBySid.surname}</td>
		</tr>
		<tr>
		<td>Email:</td>
		<td>${studentBySid.email}</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		</tr>
		</table>
		<%}  %>
	</div>

</body>
</html>