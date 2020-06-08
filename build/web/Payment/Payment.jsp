<%-- 
    Document   : Payment
    Created on : 06/06/2020, 4:50:24 PM
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
            <form method="post" action="PaymentConfirm.jsp">
                <div class="mainContainer">
                    <table class="mainContainer"> 
                    <h1>Payment</h1>
                    <%--Get User input information for the payment to be made --%>
                    <tr><td>Account Name</td><td><input type="String" placeholder="Joe Briggs" name="Account Name"></td></tr>           
                    <tr><td>Account Number</td><td><input type="String" placeholder="1234 56789 1011" name="Account Number"></td></tr>           
                    <tr><td>Payment Method</td><td><input type="String" placeholder="Credit Card" name="Payment_Method"></td></tr>           
                    <tr><td>Date</td><td><input type="String" placeholder="10/3/2020" name="Date"></td></tr>           
<!--//GET FROM Eduardo --> <tr><td>Total_Amount</td><td><input type="String" placeholder="$_._" name="Total Amount"></td></tr>           
                            <!--Submit for the payment-->
                    <tr><td></td><td><input type="submit" value="Pay"></td></tr>     
                        </table>
                </div>
            </form>
        <!--Logout and Navigation to Payment Details-->
        <div class="mainContainer">
            <a href="../welcome.jsp">Back</a>   <!-- Need to fix to order -->
            <a href="readPayments.jsp">Payment Details</a>
        </div>
    </body>
</html>