<%-- 
    Document   : delete
    Created on : 08/06/2020, 7:15:08 PM
    Author     : Karl Silis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product</title>
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
                <li><a href="display.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Are you sure you want to Delete this Product?</h1>
            <p>This cannot be undone</p><br>
            <p>*add product to be deleted.</p>
            <a href="search.jsp" >Yes</a>
            <a href="search.jsp" >No</a><br><br>
        </div>
    </body>
</html>