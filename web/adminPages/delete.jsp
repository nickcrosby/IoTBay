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
        <div class="mainContainer">
            <h1>Administrative Dashboard</h1>
            <p>Delete existing staff member records</p><br>.

            <div class="staffDelete"> 
                <!--Delete by FIRST name-->
                <section>
                    <p>Delete by: First Name</p><br>
                    <form method="post" action="">
                        <table class="mainContainer">
                            <tr><td>First Name</td><td><input type="text" placeholder="First Name" name="fname"></td></tr>          
                            <!--Delete staff member-->
                            <tr><td></td><td><input type="submit" value="Delete"></td></tr>     
                        </table>
                    </form>
                </section><br>

                <!--Delete by LAST name-->
                <section>
                    <p>Delete by: Last Name</p><br>
                    <form method="post" action="">
                        <table class="mainContainer">
                            <tr><td>Last Name</td><td><input type="text" placeholder="Last Name" name="lname"></td></tr>          
                            <!--Delete staff member-->
                            <tr><td></td><td><input type="submit" value="Delete"></td></tr>     
                        </table>
                    </form>
                </section><br>

                <!--Delete by FIRST and LAST name-->
                <section>
                    <p>Delete by: First Name <strong>AND</strong> Last Name</p><br>
                    <form method="post" action="">
                        <table class="mainContainer">
                            <tr><td>First/Last Name</td><td><input type="text" placeholder="First and Last Name" name="flname"></td></tr>          
                            <!--Delete staff member-->
                            <tr><td></td><td><input type="submit" value="Delete"></td></tr>     
                        </table>
                    </form>
                </section><br>          
            </div>
            <a href="dashboard.jsp" class="backButton">Back</a>
            <a href="../logout.jsp">Logout</a>
        </div>
    </body>
</html>
