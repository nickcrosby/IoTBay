<%-- 
    Document   : display
    Created on : 08/06/2020, 6:49:09 PM
    Author     : Karl Silis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Product</title>
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
                <li><a href="search.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Product Administrative Dashboard</h1>
            <p>Select, and Update/Delete Products from the Catalogue</p><br>
            <p>*add found Products to select.</p>
            <a href="update.jsp" >Update Selected Product</a>
            <a href="delete.jsp" >Delete Selected Product</a><br><br>
        </div>
    </body>
</html>