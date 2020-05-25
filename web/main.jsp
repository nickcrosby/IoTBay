<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Get the registration information of users-->
        <%
            Customer customer = (Customer) session.getAttribute("customer");
        %>
        <section>
            <!--USer profile-->
            <div class="mainContainer">
                <h1>User Profile</h1>
                <table class="mainProfile">
                    <thead><th>First Name</th> <th>Last Name</th> <th>Address</th> <th>Phone</th> <th>Password</th> <th>D.O.B</th> <th>Email</th></thead>
                    <!--Placeholder to auto fill fields-->
                    <tr><td>${customer.fname}</td> <td>${customer.lname}</td> <td>${customer.phone}</td> <td>${customer.password}</td> <td>${customer.dob}</td> <td>${customer.email}</td> <td>${customer.address}</td></tr>
                </table>
                <!--Logout-->
                <div class="mainContainer">
                    <a href="logout.jsp" class="logout">Logout</a>
                </div>
            </div>
        </section>
    </body>
</html>
