<%@page import="uts.isd.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body>
        <%
            Staff staff = null;
            if (session.getAttribute("staff") != null) {
                staff = (Staff) session.getAttribute("staff");
            }
            String updated = null;
            if (session.getAttribute("updated") != null) {
                updated = (String) session.getAttribute("updated");
            }
            staff = new Staff("", "", "", "");
        %>
        <!--Main site image-->
        <div class="bgimage">
        </div>
        <!--Navigation bar-->
        <div class="navbar">
            <ul class="navbarElements">
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="dashboard.jsp">Back</a></li>
                <li><a href="../logout.jsp">Logout</a></li>
            </ul>
        </div>
        <!--Main titles-->
        <div class="mainContainer">
            <h1>Administrative Dashboard</h1>
            <p>View and filter existing staff member records</p><br>
            <!--Main titles-->
            <div class="mainContainer">
                <section class="mainContainer">
                    <!--Read staff information-->
                    <!--View records one by one-->
                    <form method="post" action="">
                        <table class="mainContainer">
                            <p>View Records</p>
                            <tr><td></td><td><input type="text" name="email" value="${staff.getEmail}" placeholder="Email"/></td></td></tr>
                            <tr><td></td><td><%=staff.getFname()%><input type="text" name="firstname" value="<%=staff.getFname()%>" placeholder="First Name"/></td></td></tr> 
                            <tr><td></td><td> <%=staff.getLname()%><input type="text" name="lastname" value="<%=staff.getLname()%>" placeholder="Last Name"/></td>  </td></tr>  
                            <tr><td></td><td> <%=staff.getPassword()%><input type="password" name="password" value="<%=staff.getPassword()%>" placeholder="Password"/></td></td></tr>            
                            <!--Create record-->
                            <tr><td></td><td><input type="submit" value="Back"></td></tr>
                            <tr><td></td><td><input type="submit" value="Next"></td></tr>
                        </table><br><br>
                        <!--Search for specific records-->
                    </form>
                    <form method="post" action="">
                        <table class="mainContainer">
                            <p>Search</p>
                            <tr><td></td><td><input type="text" name="email" value="${staff.getEmail}" placeholder="Search by Email"/></td></td></tr>
                            <tr><td></td><td><%=staff.getFname()%><input type="text" name="firstname" value="<%=staff.getFname()%>" placeholder="Search by First Name"/></td></td></tr> 
                            <tr><td></td><td> <%=staff.getLname()%><input type="text" name="lastname" value="<%=staff.getLname()%>" placeholder="Search by Last Name"/></td>  </td></tr>         
                            <!--Create record-->
                            <tr><td></td><td><input type="submit" value="Search"></td></tr>
                        </table>
                    </form>
                </section>
            </div>
        </div>
    </body>
</html>
