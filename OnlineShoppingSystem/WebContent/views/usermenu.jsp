<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer page</title>
</head>
<body>
      <style>
          h2 {text-align:center;}
         </style>
                 <h2>${login1}</h2> 
         <center>
          <a href="cart.jsp"><h2>add product to cart</h2></a><br>
          <a href="displaylist"><h2>display all products</h2></a><br>
          <a href="displaycart"><h2>display cart product</h2></a><br>
          <a href="paybill"><h2> pay bill</h2></a><br>
          <a href="showbalance"><h2>show wallet</h2></a><br>
          <a href="addbalance.jsp"><h2>add balance to cart</h2></a><br>
         </center>
</body>
</html>