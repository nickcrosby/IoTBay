/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author ncrosby17
 */
public class RegisterServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response); 
        } else if (!validator.validateName(fname)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(lname)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(address)) {
            session.setAttribute("nameErr", "Error: Address format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePhone(phone)) {
            session.setAttribute("phoneErr", "Error: Phone format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateDate(dob)) {
            session.setAttribute("dateErr", "Error: Date format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);  
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                Customer exist = manager.findCustomer(email, password);
                if (exist != null) {
                    session.setAttribute("existErr", "User already exists in the database");
                    request.getRequestDispatcher("register.jsp").include(request, response); 
                } else {
                    manager.addCustomer(email, fname, lname, address, phone, dob, password);
                    Customer customer = new Customer(email, fname, lname, address, phone, dob, password);
                    session.setAttribute("customer", customer);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
