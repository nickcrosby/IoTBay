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
        <div class="mainContainer">
            <h1>Administrative Dashboard</h1>
            <p>Staff Management Console</p><br>
            
            <!--CRUD management pages-->
            <a href="create.jsp" >Create</a>
            <a href="read.jsp" >Read</a>
            <a href="update.jsp" >Update</a>
            <a href="delete.jsp" >Delete</a><br><br>
            
            <a href="index.jsp" class="backButton">Back</a>
            <a href="../logout.jsp">Logout</a>
        </div>
    </body>
</html>
