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
import uts.isd.model.*;

/**
 *
 * @author ncrosby17
 */
public class LoginServlet extends HttpServlet{
    
             //1- retrieve the current session

             @Override
             protected void doPost(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
                 HttpSession session = request.getSession();
                 Validator validator = new Validator();
                 String email = request.getParameter("email");
                 String password = request.getParameter("password");
                 DBManager manager = (DBManager) session.getAttribute("manager");
                 Customer customer = null;
                 validator.clear(session);
                 
                 if (!validator.validateEmail(email)) {
                     session.setAttribute("emailErr", "Error: Email format incorrect");
                     request.getRequestDispatcher("login.jsp").include(request, response);
                 } else if (!validator.validatePassword(password)) {
                     session.setAttribute("passwordErr", "Error: Password format incorrect");
                     request.getRequestDispatcher("login.jsp").include(request, response);
                 } else {
                     try {
                         customer = manager.findCustomer(email, password);
                         if (customer != null) {
                             session.setAttribute("customer", customer);
                             request.getRequestDispatcher("main.jsp").include(request, response);
                         } else {
                             session.setAttribute("existErr", "Customer does not exist in the database");
                             request.getRequestDispatcher("login.jsp").include(request, response);
                         }
                     } catch (SQLException | NullPointerException ex) {
                         System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
                     }
                 }
                 
             }
}