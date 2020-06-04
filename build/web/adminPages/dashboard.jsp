<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
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
                <li><a href="../login.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Administrative Dashboard</h1>
            <p>Staff Management Console</p><br>
            <!--CRUD management pages-->
            <a href="create.jsp" >Create Records</a>
            <a href="read.jsp" >Read Records</a>
            <a href="update.jsp" >Update Records</a>
            <a href="delete.jsp" >Delete Records</a><br><br>
        </div>
    </body>
</html>
