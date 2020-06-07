package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Staff;
import uts.isd.model.dao.DBManager;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class  
        Validator validator = new Validator();
        //3- capture the posted form data
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        //4- retrieve the manager instance from session 
        DBManager manager = (DBManager) session.getAttribute("manager");
        Staff staff = null;

        try {
            if (staff != null) {
                session.setAttribute("staff", staff);
                manager.updateStaff(email, firstname, lastname, password);
                session.setAttribute("Updated", "Update was successful");
                request.getRequestDispatcher("dashboard.jsp").include(request, response);
            } else {
                session.setAttribute("Updated", "Update was unsuccessful");
                request.getRequestDispatcher("dashboard.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
