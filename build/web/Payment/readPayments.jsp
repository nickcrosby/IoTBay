<%-- 
    Document   : readPayments
    Created on : 08/06/2020, 5:28:07 PM
    Author     : conce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment History</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../welcome.jsp">Welcome</a></li>
                <li><a href="UpdatePayment.jsp">Update Payment</a></li>
                <li><a href="deletePayment.jsp">Delete Payment</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <div class="mainContainer">
            <h1>Payment History</h1>
            <p>Payment History</p><br>
            <table class="mainContainer">
                <tr><td>Account Name</td><td><input type="text" placeholder="Search and Display Account Name" name="AName"></td></tr> 
                <tr><td>Account Number</td><td><input type="text" placeholder="Search and Display Account Number" name="ANumber"></td></tr>  
                <tr><td>Expiry Date</td><td><input type="date" placeholder="Search and Display Expiry Date" name="EXPDate"></td></tr>
                <!--Search and Delete record-->
                <tr><td></td><td><input type="submit" value="Search"></td></tr>                     
            </table>
        </div>
    </body>
</html>
