<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre><form:form action="/student" method="post"  commandName="student"  >  
FirstName :<form:input  path="firstName"/>
LastName :<form:input  path="lastName"/>
Email:<form:input  path="email"/>
<input type="submit" value="Submit"/>
</form:form>
</pre>
</body>
</html>