<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
                    <style>
                    table, tr, td
                    {
                         border: 2px solid black;
                         width : 40%;
                         text-align: center; 
                         border-collapse: collapse;
                    }
                    table.center 
                    {
                          margin-left: auto;
                          margin-right: auto;
                          
                    }
  
                  </style>

<meta charset="ISO-8859-1">

<title>Avaliable Products</title>
</head>
<body>
    <center><h1>products list</h1></center>
    
             <table class="center">
                                
                                <tr>
                                    <td>Product No</td>
                                    <td>Product Name</td>
                                    <td>Product Cost</td>
                                    <td>Discount</td>
                                    <td>Quantity</td>
                                 </tr>
    
    <c:forEach var="s" items="${list}">
                                
                            <tr>
                                    <td><c:out value="${s.getPid()}"></c:out></td>
                                    <td><c:out value="${s.getPname()}"></c:out></td>
                                    <td><c:out value="${s.getCost()}"></c:out></td>
                                    <td><c:out value="${s.getPdis()}"></c:out></td>
                                    <td><c:out value="${s.getPqun()}"></c:out></td>
                            </tr>
                            
                    </c:forEach>        
                    </table>
        
    
</body>