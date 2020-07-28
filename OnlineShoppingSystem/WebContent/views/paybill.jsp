<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="getbill">
        <%! int fontSize; %>
       
        <table border ="5">
        <tr>
        <td align="centre" bgcolor="green" colspan="7"><h1>Welcome To online shopping</h1></td>
        </tr>   
       
                <tr>
                           
                            <td>Product id</td>
                            <td>Product Name</td>
                            <td>Product cost</td>
                            <td>Product quantity</td>
                            <td>Product discount</td>
                            
                       
                           
                </tr>
                <c:forEach var="l" items="${list}">
               
                <tr>
               
               
                            <td>"${l.pid}"</td>
                            <td>"${l.name}"</td>
                            <td>"${l.cost}"</td>
                            <td>"${l.pquan}"</td>
                            <td>"${l.pdis}"</td>
                           
                           
           
                </tr>   
                </c:forEach>
       
        </table>
        <input type="submit" name="payBill">
       
</form>

</body>
</html>