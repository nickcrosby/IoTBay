<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Retrieve form data from registration form-->
        <%
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
        %>
        <section class="mainContainer">
            <div>
                <!--Registration data display-->
                <h1>Welcome, <%= fname%></h1>
                <p>First Name: <%= fname%></p><br>
                <p>Last Name: <%= lname%></p><br>
                <p>Phone: <%= phone%></p><br>
                <p>Password: <%= password%></p><br>
                <p>Date of Birth: <%= dob%></p><br>
                <p>Email Address: <%= email%></p><br>
                <p>Address: <%= address%></p><br>
            </div>
            <!--Go to main and logout-->
            <div>
                <a href="main.jsp">Main</a>
                <a href="catalogue.jsp">Catalogue</a>
                <a href="logout.jsp">Logout</a>
            </div>
        </section>

        <!--Retrieve user from Java Beans-->
        <!--Store user data into session-->
        <!--Transport user data to Main-->
        <%
            Customer customer = new Customer(fname, lname, phone, password, dob, email, address);
            session.setAttribute("customer", customer);
        %>
    </body>
</html>
