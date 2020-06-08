<%-- 
    Document   : UpdatePayment
    Created on : 08/06/2020, 5:23:00 PM
    Author     : conce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Payment</title>
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
                <li><a href="deletePayment.jsp">Delete Payment</a></li>
                <li><a href="readPayments.jsp">Read Payment</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <section class="mainContainer">
            <h1>Update Payment</h1>
            <p>Update payment details</p><br>    
            <form method="post" action="">
                <table class="mainContainer">
                    <%-- Information to be updated --%>
                    <tr><td>Account Name</td><td><input type="text" placeholder="Account Name" name="AName"></td></tr> 
                    <tr><td>Account Number</td><td><input type="text" placeholder="0000 00000 0000" name="ANumber"></td></tr>  
                    <tr><td>Expiry Date</td><td><input type="date" placeholder="Expiry Date" name="EXPDate"></td></tr>
                    <!--Update record-->
                    <tr><td></td><td><input type="submit" value="Update"></td></tr>     
                </table>
            </form>
        </section>
    </body>
</html>
