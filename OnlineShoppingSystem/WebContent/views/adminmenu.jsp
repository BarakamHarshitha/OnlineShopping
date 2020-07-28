<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
      
         <style>
          h2 {text-align:center;}
         </style>
                 <h2>${login}</h2> 
         <center>
          <a href="addproduct.jsp"><h2>add product</h2></a><br>
          <a href="displayall"><h2>display all product</h2></a><br>
          <a href="display.jsp"><h2>display product</h2></a><br>
          <a href="delete.jsp"><h2>delete product</h2></a><br>
          <a href="adduser.jsp"><h2>add user</h2></a><br>
          <a href="removeuser.jsp"><h2>delete user</h2></a><br>
         </center>
             
         
</body>
</html>