<%@page import="com.springmvc.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>|||All Data|||</title>
</head>
<body>
	<div align="center">
		<br /> <br /> <br />
		<h1>All Data</h1>
		<table style="border: 1px solid black;">
			<tr align="center"  >
				<th>Sid</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Email</th>
			</tr>
			<%
			for (Student s : (List<Student>) request.getAttribute("studList")) {
			%>
			<tr align="center">
				<td><%=s.getSid()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getSurname()%></td>
				<td><%=s.getEmail()%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="4"><a href="curdIndex.jsp">Goto Curd Index</a></td>
			</tr>
		</table>
	</div>

</body>
</html>