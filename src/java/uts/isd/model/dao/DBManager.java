/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import uts.isd.model.Customer;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ncrosby17
 */

public class DBManager {
    
    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    //Find customer by ID in the database - read one row in the database table
    public Customer findCustomer(String email, String password) throws SQLException {
        //setup the select sql query string
        String fetch = "select * from IOTUSER.CUSTOMER where EmailAddress = '" + email + "' and PASSWORD = '" + password + "'";
        //execute this query using the statement field
        ResultSet rs = st.executeQuery(fetch);
        //add the results to a ResultSet 
        while (rs.next()) {
            String customerEmail = rs.getString(1);
            String customerPassword = rs.getString(7);
                if (customerEmail.equals(email) && customerPassword.equals(password)){
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);
                    String dob = rs.getString(6);
                    String address = rs.getString(4);
                    String phone = rs.getString(5);
                    //search the ResultSet for a user using the parameters
                    return new Customer(email, firstName, lastName, address, phone, dob, password);
                }
        } return null;
    }
    
    //Add a customer-data into the database   
    public void addCustomer(String email, String fname, String lname, String address, String phone, String dob, String password) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.CUSTOMER " + "VALUES ('" + email + "', '" + fname + "', '" + lname + "', '" + address + "', '" + phone + "', '" + dob + "', '" + password + "'");
    }
    
    //update a customer details in the database   
    public void updateCustomer(String email, String fname, String lname, String address, String phone, String dob, String password) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.CUSTOMER SET EmailAddress = '" + email + "', FIRSTNAME = '" + fname + "', LASTNAME = '" + lname + "',"
                + "ADDRESS = '" + address + "', PHONE = '" + phone + "', DOB = '" + dob + "', PASSWORD = '" + password + "'");
    }
    
    //delete a customer from the database   
    public void deleteCustomer(String email) throws SQLException {
        //code for delete-operation
        st.executeUpdate("DELETE FROM IOTUSER.CUSTOMER WHERE EMAILADDRESS = '" + email + "'");
    }
    
    //fetch all customers in the database
    public ArrayList<Customer> fetchCustomers() throws SQLException {
        String fetch = "select * from CUSTOMER";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> temp = new ArrayList();
        
        while (rs.next()) {
            String email = rs.getString(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String address = rs.getString(4);
            String phone = rs.getString(5);
            String dob = rs.getString(6);
            String password = rs.getString(7);
            temp.add(new Customer(email, fname, lname, address, phone, dob, password));
        }
        return temp;
    }
    
    //read every row from USERS and verify if user exists or not
    public boolean checkCustomer(String email, String password) throws SQLException {
        String fetch = "select * from IOTUSER.CUSTOMER where EmailAddress = '" + email + "' and PASSOWRD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String customerEmail = rs.getString(1);
            String customerPassword = rs.getString(7);
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}


