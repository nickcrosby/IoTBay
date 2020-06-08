<%-- 
    Document   : deletePayment
    Created on : 05/06/2020, 5:46:03 PM
    Author     : conce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Navigation bar-->
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../welcome.jsp">Welcome</a></li>
                <li><a href="UpdatePayment.jsp">Update Payment</a></li>
                <li><a href="readPayments.jsp">Read Payment</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Delete Payments</h1>
            <p>Delete Payments</p><br>
            <table class="mainContainer">
                <%-- Information to be deleted from the users account --%>
                <tr><td>Account Name</td><td><input type="text" placeholder="Delete Account Name" name="AName"></td></tr> 
                <tr><td>Account Number</td><td><input type="text" placeholder="Delete Account Number" name="ANumber"></td></tr>  
                <tr><td>Expiry Date</td><td><input type="date" placeholder="Delete Expiry Date" name="EXPDate"></td></tr>
                <!--Search and Delete record-->
                <tr><td></td><td><input type="submit" value="Delete"></td></tr>                     
            </table>
        </div>
    </body>
</html>
