<%-- 
    Document   : edit
    Created on : 08/06/2020, 7:10:26 PM
    Author     : ncrosby17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <div><span class="time" id="time/>"</div>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String)session.getAttribute("updated");
        %>
        
        <div>
            <a class="button" href="MainServlet?email='<%= customer.getEmail()%>'&password='<%=customer.getPassword()%>'">Main</a>
            <a class="button" href="logout.jsp">Logout</a>
        </div>
        
        <h1>Edit Customer Information</h1>
        <form method="post" action="UpdateServlet">
            <table>
                <tr><td>Email:</td><td><input type="text" name="email" value="${customer.email}"</td></tr>
                <tr><td>First Name:</td><td><input type="text" name="fname" value="${customer.fname}"</td></tr>
                <tr><td>Last Name:</td><td><input type="text" name="lname" value="${customer.lname}"</td></tr>
                <tr><td>Address:</td><td><input type="text" name="address" value="${customer.address}"</td></tr>
                <tr><td>Phone Number:</td><td><input type="text" name="phone" value="${customer.phone}"</td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" value="${customer.dob}"</td></tr>
                <tr><td>Password:</td><td><input type="text" name="password" value="${customer.password}"</td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
