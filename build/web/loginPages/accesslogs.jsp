<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Logs</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../welcome.jsp">Welcome</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <div class="mainContainer">
            <h1>View your access logs:</h1>
        <table class="mainProfile">
            <tr>
            <thead>
                <th>Date Logged In:</th>
                <th>Date Logged Out:</th>
            </thead>
            <tr>
                <td>N/A</td>
                <td>N/A</td>
            </tr>
            <div class="mainContainer">
                <a href="welcome.jsp">Back</a>
                <a href="logout.jsp" class="logout">Logout</a>    
            </div>
        </table>
        </div>
    </body>
</html>