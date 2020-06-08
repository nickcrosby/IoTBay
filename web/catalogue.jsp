<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Navigation bar-->
        <div class="navbar">
            <ul class="navbarElements">

                <li><a href="index.jsp">Home</a></li>
                <a href="OrderManagment/dashboard.jsp" id="orderpage">Order</a>

                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </div>
        <div class="mainContainer">
            <h1>Device Catalogue</h1>
            <p>View the Catalogue here!</p>
            <!--Logout and Back navigation-->
        </div>
        <a href="Payment/Payment.jsp" id="Payment">Payment</a>
    </body>
</html>
