<%-- 
    Document   : search
    Created on : 08/06/2020, 6:19:09 PM
    Author     : Karl Silis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Catalogue</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Navigation bar-->
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="login.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Catalogue Administrative Dashboard</h1>
            <p>Search For Existing or Add New Catalogue Products</p><br>
            <p>*add search items for ProductId, and ProductName.</p>
            <a href="display.jsp" >Display Found Products</a>
            <a href="add.jsp" >Add New Products</a><br><br>
        </div>
    </body>
</html>
