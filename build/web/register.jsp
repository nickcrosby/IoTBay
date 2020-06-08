<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="styles/style.css">
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String dateErr = (String) session.getAttribute("dateErr");
        %>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Navigation bar-->
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="index.jsp">Home</a></li>
            </ul>
        </div>
        <section class="mainContainer">
            <h1>Registration</h1>
            <p>Create a new account</p><br>
            <!--New user form-->
            <form method="post" action="RegisterServlet">
                <table class="mainContainer">
                    <tr><td>Email</td><td><input type="email" placeholder="Email" name="email"></td></tr>
                    <tr><td>First Name</td><td><input type="text" placeholder="First Name" name="fname"></td></tr> 
                    <tr><td>Last Name</td><td><input type="text" placeholder="Last Name" name="lname"></td></tr>  
                    <tr><td>Address</td><td><input type="text" placeholder="Address" name="address"></td></tr>
                    <tr><td>Phone</td><td><input type="text" placeholder="Phone Number" name="phone"></td></tr>
                    <tr><td>D.O.B</td><td><input type="date" placeholder="dob" name="dob"></td></tr>
                    <tr><td>Password</td><td><input type="password" placeholder="Password" name="password"></td></tr>            
                    <!--Submit-->
                    <tr><td>
                            <a href="CancelServlet" class="button"> Cancel </a> 
                        </td><td><input class="button" type="submit" value="Register"></td></tr>     
                </table>
            </form>
        </section>
    </body>
</html>