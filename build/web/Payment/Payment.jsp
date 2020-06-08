<%-- 
    Document   : Payment
    Created on : 08/06/2020, 4:50:24 PM
    Author     : conce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        </div>
            <h1>Payment</h1><br>
            <form method="post" action="order.jsp">
                <div class="PaymentForm">
                        <table class="mainContainer"> 
                            <tr><td>Total_Amount</td><td><input type="String" placeholder="$_._" name="Total Amount"></td></tr>           
                            <!--Submit-->
                            <tr><td></td><td><input type="submit" value="Pay"></td></tr>     
                        </table>
                </div>
            </form>
            </div>
        <!--Logout and Back navigation-->
        <div class="mainContainer">
            <a href="welcome.jsp">Back</a>   <!-- Need to fix to order -->
            <a href="readPayments.jsp">Read Payments</a>
        </div>
    </body>
</html>