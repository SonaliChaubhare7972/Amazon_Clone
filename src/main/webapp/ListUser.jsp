<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table border="2">
  
    <tr>
    <th>student iD</th>
    <th>student name</th>
    <th>student city</th>
   
    <th>Edit<th>
    <th>Delete<th>
    </tr>
    <c:forEach var="std" items="${e_data}">
    
      <tr>
      <td>${std.id}</td>
      <td>${std.name}</td>
      <td>${std.city}</td>
   
      <td><a href="<c:url value='/edit/${std.id }'/>">Update</a> </td>
      <td><a href="<c:url value='/${std.id }'/>">Delete</a> </td>
     
      </tr>
     
    </c:forEach>
 
  </table>
</body>
</body>
</html>