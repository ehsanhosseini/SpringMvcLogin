<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yahoo!!!!!!!! JSP</title>
</head>
<body>

<p> <font color="red">${errormessage}</font> </p>

<form action="/login" method="POST">

Name <input type="text" name="name"/>
Password <input type="password" name="password"/> <br><br>
				<input type="submit" value="Login">
</form>


</body>
</html>