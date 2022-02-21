<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	Welcome to Home Page
	<hr>
	<form action="addStudent">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="submit" value="ADD">		
	</form>
	
	<form action="getStudent">
		<br><input type="text" name="id">	<br>	
		<input type="submit" value="GET">		
	</form>
</body>
</html>