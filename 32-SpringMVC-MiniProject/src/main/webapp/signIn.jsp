<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign page</title>
<style type="text/css">
.error{
 color: red;
}
</style>
</head>
<body>
	<div align="center">
		<br /> <br /> <br />
		<h1>SignIn Page</h1>
		<h2>${requestScope.status}</h2>
		<form:form action="signIn" method="POST" modelAttribute="admin">
			<table>
				<tr>
					<td>Email:</td>
					<td><form:input path="user" /></td>
					<td><form:errors path="user" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><a href="add">SignUp</a></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>