<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
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
                <li><a href="../catalogue.jsp">Catalogue</a></li>
                <li><a href="dashboard.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Administrative Dashboard</h1>
            <p>Create new staff member records</p><br>
            <section class="mainContainer">
                <!--Create a new user-->
                <!--Insert new staff members into database-->
                <form method="post" action="">
                    <table class="mainContainer">
                        <tr><td>First Name</td><td><input type="text" placeholder="First Name" name="fname"></td></tr> 
                        <tr><td>Last Name</td><td><input type="text" placeholder="Last Name" name="lname"></td></tr>  
                        <tr><td>Phone</td><td><input type="text" placeholder="Phone Number" name="phone"></td></tr>
                        <tr><td>Email</td><td><input type="email" placeholder="Email" name="email"></td></tr>
                        <tr><td>Address</td><td><input type="text" placeholder="Address" name="address"></td></tr> 
                        <tr><td>D.O.B</td><td><input type="date" placeholder="dob" name="dob"></td></tr>
                        <tr><td>Password</td><td><input type="password" placeholder="Default Password" name="password"></td></tr>            
                        <!--Create record-->
                        <tr><td></td><td><input type="submit" value="Create"></td></tr>     
                    </table>
                </form>
            </section>
        </div>
    </body>
</html>
