
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Payment;
import uts.isd.model.dao.*;

/**
 *
 * @author Concetto
 */
public class TestDB02 {
    
    private static Scanner in = new Scanner (System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    
    public static void main(String[] args) throws SQLException {
        (new TestDB02()).runQueries();
    }
    
    public TestDB02() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.print("Operation CRUD or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException {
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
                    testDisplay();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
                            
            }
        }
    }
    
    private void testAdd() {
        
        System.out.print("Payment ID: ");
        int paymentID = Integer.parseInt(in.nextLine());
        System.out.print("Account name: ");
        String account_Name = in.nextLine();
        System.out.print("Account Number: ");
        int account_Number = Integer.parseInt(in.nextLine());
        System.out.print("Payment Method: ");
        String payment_Method = in.nextLine();
        System.out.print("Date: ");
        String date = in.nextLine();
        System.out.print("Total Amount: ");
        int total_amount = Integer.parseInt(in.nextLine());
        System.out.print("expiry Date: ");
        String expDate = in.nextLine();
        
        try {
            db.addPayment(paymentID, account_Name, account_Number, payment_Method, date, total_amount, expDate);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB02.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Payment is added to the database");
    }
    
    
    private void testRead() throws SQLException{
        
        System.out.print("Payment ID: ");
        int paymentID = Integer.parseInt(in.nextLine());
        System.out.print("Account name: ");
        String account_Name = in.nextLine();
        System.out.print("Account Number: ");
        int account_Number = Integer.parseInt(in.nextLine());
        System.out.print("Payment Method: ");
        String payment_Method = in.nextLine();
        System.out.print("Date: ");
        String date = in.nextLine();
        System.out.print("Total Amount: ");
        int total_amount = Integer.parseInt(in.nextLine());
        System.out.print("expiry Date: ");
        String expDate = in.nextLine();
        
        Payment payment = db.findPayment(paymentID, date);
        
        if (payment != null) {
            System.out.println("Payment " + payment.getAccount_Name() + " exists in the database.");
        } else {
            System.out.println("Payment does not exist");
        }

    }
    
    private void testUpdate() {
        
        System.out.print("Payment ID: ");
        int paymentID = Integer.parseInt(in.nextLine());
        System.out.print("date: ");
        String date = in.nextLine();

        try {
            if (db.checkPayment(paymentID, date)) {
                System.out.print("Account Name: ");
                String account_Name = in.nextLine();
                System.out.print("Account Number: ");
                int account_Number = Integer.parseInt(in.nextLine());
                System.out.print("Payment Method: ");
                String payment_Method = in.nextLine();
                System.out.print("Total Amount: ");
                int total_amount = Integer.parseInt(in.nextLine());
                System.out.print("expiry Date: ");
                String expDate = in.nextLine();
                db.updatePayment(account_Name, account_Number, expDate);
            } else {
                System.out.println("Payment does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() {
        System.out.print("Payment ID: ");
        int paymentID = Integer.parseInt(in.nextLine());
        System.out.print("Total Amount: ");
        String date = in.nextLine();
        
        try {
            if (db.checkPayment(paymentID, date)) {
                db.deletePayment(paymentID);
            } else {
                System.out.println("Payment does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDisplay() {
        try {
            ArrayList<Payment> payment = db.displayPayment();
            System.out.println("Payment TABLE: ");
            payment.stream().forEach((payments) -> {
                System.out.printf("%-10s %-20s %-20s %-20s %-20s %-10s %-20s\n",payments.getPaymentID(), payments.getAccount_Name(), payments.getAccount_Number(), payments.getPayment_Method(), payments.getDate(), payments.getTotal_amount(), payments.getExpDate());
            });
            System.out.println();
            } catch (SQLException ex) {
                Logger.getLogger(TestDB02.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
}
