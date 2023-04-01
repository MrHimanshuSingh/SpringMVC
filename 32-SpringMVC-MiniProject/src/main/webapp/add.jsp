<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>|||Add Data|||</title>
<style type="text/css">
.error{
 color: red;
}
</style>
</head>
<body>
	<div align="center">
		<br /> <br /> <br />
		<h1>Insert student Form</h1>
		<h2 style="color: green;">${requestScope.status}</h2>
		<form:form action="add" method="POST" modelAttribute="student">
			<table>
				<tr>
					<td>Sid:</td>
					<td><form:input path="sid" /></td>
					<td><form:errors path="sid" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><form:input path="surname" /></td>
					<td><form:errors path="surname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email"  cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><a href="curdIndex.jsp">Goto Curd Index</a></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>