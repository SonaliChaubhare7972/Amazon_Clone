<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="/update/${std1.id}" method="post">
	<lable>Name</lable>
	<input type="text" id="name" name="name" value="${std1.name }">
	
	<lable>City</lable>
	<input type="text" id="city" name="city" value="${std1.city }">

	
	<button type="submit">Update</button>
	</form>
</body>
</body>
</html>