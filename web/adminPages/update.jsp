<%@page import="uts.isd.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link rel="stylesheet" href="../styles/style.css">
    </head>
    <body onload="startTime()">
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
            <p>Update existing staff member records: <span class="message"> <%=(updated != null ? updated : "")%> </span></p><br>
            <section class="mainContainer">
                <!--Create a new user-->
                <!--Update staff information-->
                <form method="post" action="">
                    <table class="mainContainer">
                        <tr><td>Email</td><td><input type="text" name="email" value="${staff.getEmail}" placeholder="Email"/></td></td></tr>
                        <tr><td>First Name</td><td><%=staff.getFname()%><input type="text" name="firstname" value="<%=staff.getFname()%>" placeholder="First Name"/></td></td></tr> 
                        <tr><td>Last Name</td><td> <%=staff.getLname()%><input type="text" name="lastname" value="<%=staff.getLname()%>" placeholder="Last Name"/></td>  </td></tr>  
                        <tr><td>Password</td><td> <%=staff.getPassword()%><input type="password" name="password" value="<%=staff.getPassword()%>" placeholder="Password"/></td></td></tr>            
                        <!--Create record-->
                        <tr><td></td><td><input type="submit" value="Update"></td></tr>     
                    </table>
                </form>
            </section>
        </div>
        <jsp:include page ="/ConnServlet" flush="true"/>
    </body>
</html>
