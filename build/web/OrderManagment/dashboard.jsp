<%-- 
    Document   : dashboard
    Created on : 08/06/2020, 11:18:55 PM
    Author     : eduardomoraza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Dashboard</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="../catalogue.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
       
         <div class="mainContainer">
            <h1>Order Dashboard</h1>
            <p>Create an order, View order history, update/delete saved orders</p><br>
            <!--CRUD management pages-->
            <a href="create.jsp" >Create</a>
            <a href="read.jsp" >Read Order</a>
            <a href="update.jsp" >Update Order</a>
            <a href="delete.jsp" >Delete Order</a><br><br>
        </div>
    </body>
</html>
