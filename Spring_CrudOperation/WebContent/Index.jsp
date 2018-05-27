
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Student.do" name="student" method="POST">  
FirstName :<input name="firstName"/>
LastName :<input  name="lastName"/>
Email:<input  name="email"/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>