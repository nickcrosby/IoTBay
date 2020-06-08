<%-- 
    Document   : read
    Created on : 01/06/2020, 11:25:11 AM
    Author     : eduardomoraza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Cart</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
         <div class="bgimage">
        </div>
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="dashboard.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <div class="mainContainer">
            <h1>Order History</h1>
            <table class="mainProfile">
                <thead><th>OrderID</th>  <th>OrderStatus</th> <th>Cost</th> <th>Product</th> <th>Quantity</th> <th>Date</th></thead>
                <tr><td> </td>  <td></td>  <td> </td>  <td> </td>  <td> </td>  <td> </td></tr>
            </table>
            
        </div>
    </body>
</html>
