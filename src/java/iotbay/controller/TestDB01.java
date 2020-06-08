
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Customer;
import uts.isd.model.dao.*;

/**
 *
 * @author ncrosby17
 */
public class TestDB01 {
    
    private static Scanner in = new Scanner (System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    
    public static void main(String[] args) throws SQLException {
        (new TestDB01()).runQueries();
    }
    
    public TestDB01() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.print("Operation CRUD or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    void runQueries() throws SQLException {
        char c;
        
        while((c = readChoice()) != '*') {
            switch(c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
                            
            }
        }
    }
    
    private void testAdd() {
        
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User first name: ");
        String fname = in.nextLine();
        System.out.print("User last name: ");
        String lname = in.nextLine();
        System.out.print("User address: ");
        String address = in.nextLine();
        System.out.print("User phone number: ");
        String phone = in.nextLine();
        System.out.print("User date of birth: ");
        String dob = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        try {
            db.addCustomer(email, fname, lname, address, phone, dob, password);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB01.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("User is added to the database");
    }
    
    
    private void testRead() throws SQLException{
        
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User first name: ");
        String fname = in.nextLine();
        System.out.print("User last name: ");
        String lname = in.nextLine();
        System.out.print("User address: ");
        String address = in.nextLine();
        System.out.print("User phone number: ");
        String phone = in.nextLine();
        System.out.print("User date of birth: ");
        String dob = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        Customer customer = db.findCustomer(email, password);
        
        if (customer != null) {
            System.out.println("Customer " + customer.getFname() + " exists in the database.");
        } else {
            System.out.println("Customer does not exist");
        }


    }
    
    
    private void testUpdate() {
        
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        try {
            if (db.checkCustomer(email, password)) {
                System.out.print("User first name: ");
                String fname = in.nextLine();
                System.out.print("User last name: ");
                String lname = in.nextLine();
                System.out.print("User address: ");
                String address = in.nextLine();
                System.out.print("User phone number: ");
                String phone = in.nextLine();
                System.out.print("User date of birth: ");
                String dob = in.nextLine();
                db.updateCustomer(email, fname, lname, address, phone, dob, password);
            } else {
                System.out.println("Customer does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() {
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        try {
            if (db.checkCustomer(email, password)) {
                db.deleteCustomer(email);
            } else {
                System.out.println("Customer does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAll() {
        try {
            ArrayList<Customer> customers = db.fetchCustomers();
            System.out.println("CUSTOMERS TABLE: ");
            customers.stream().forEach((customer) -> {
                System.out.printf(customer.getEmail(), customer.getFname(), customer.getLname(), customer.getAddress(), customer.getPhone(), customer.getDob(), customer.getPassword());
            });
            System.out.println();
            } catch (SQLException ex) {
                Logger.getLogger(TestDB01.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
}
