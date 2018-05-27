<%@page import="beans.data.StudentRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	
<html>
<head>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${details}
<form action="student/save.do" name="save" method="POST">  
FirstName :<input name="firstName" value= "${details.firstName}" />
LastName :<input  name="lastName" value="${details.lastName}"/>
Email:<input  name="email" value="${details.email}"/>
<input type="submit" value="Submit"/>
</form>

<c:if test="${!empty students}">
<h3>Student List</h3>
	<table class="tg">
	<tr>
		<th width="50">FirstName</th>
		<th width="50">LastName</th>
		<th width="50">Email</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${students}" var="student">
		<tr>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
			<td>${student.email}</td>
			<td><a href="<c:url value='/edit/${student.firstName}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${student.firstName}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>