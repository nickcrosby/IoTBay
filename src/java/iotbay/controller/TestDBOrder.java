/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;


import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Orders;
import uts.isd.model.dao.*;


/**
 *
 * @author eduardomoraza
 */
public class TestDBOrder {
  
        private static Scanner in = new Scanner(System.in);
        private DBConnector connector;
        private Connection conn;
        private DBManager db;
        
        public static void main(String[] args) throws SQLException {
            (new TestDBOrder ()).runQueries();
         }
        public TestDBOrder() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager (conn);
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(TestDBOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        private char readChoice() {
            System.out.print("Operation CRUDS or * to exit: ");
            return in.nextLine() .charAt(0);
        }
         
        private void runQueries() throws SQLException{
        char c;
        
        while ((c = readChoice ()) != '*') {
            switch (c) {
                case 'C': 
                    testAdd();
                    break;
                case 'R': 
                    testRead();
                    break;
                case 'U': ;
                    testUpdate();
                    break;
                case 'D': ;
                    testDelete();
                    break;
                case 'S': ;
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
            
        
        
        
        private void testAdd() {
            System.out.print("OrderID: ");
            String orderID = in.nextLine();
            System.out.print("Order Status: ");
            String orderStatus = in.nextLine();
            System.out.print("Total Cost: ");
            String totalCost = in.nextLine();
            System.out.print("ProductID: ");
            String productID = in.nextLine();
            System.out.print("Quantity: ");
            String quantity = in.nextLine();
            System.out.print("Date: ");
            String date = in.nextLine();
            try{
             db.addOrders( orderID, orderStatus, totalCost, productID, quantity, date);
             } catch (SQLException ex) {
                Logger.getLogger(TestDBOrder.class.getName()).log(Level.SEVERE, null, ex);
             }
            System.out.println("Order is added to the database.");
       
               
               
        
        private void testRead() throws SQLException {
            System.out.print("OrderID: ");
            String orderID = in.nextLine();
            System.out.print("Order Date: ");
            String date = in.nextLine();
            Orders orders = db.findOrders (orderID, date);
            if (orders != null) {
                System.out.println("Orders " + orders.getOrders() +" exists in the database.");
            }    else { 
                    System.out.println("Order does not exist.");
            }
        }
        
        private void testUpdate() {
        System.out.print("OrderID: ");
       String orderID = in.nextLine();
       System.out.print("Order Date: ");
       String date = in.nextLine();
       
       try {
           if (db.checkOrders (orderID, date)) {
               System.out.print("Order Status: ");
               String orderStatus = in.nextLine();
               System.out.print("Total Cost: ");
               String totalCost = in.nextLine();
               System.out.print("ProductID: ");
               String productID = in.nextLine();
               System.out.print("Quantity: ");
               String quantity = in.nextLine();
               db.updateOrders (orderID, orderStatus, totalCost, productID, quantity, date);
           } else {
               System.out.println("User does not exist.");
           }
       } catch (SQLException ex) {
           Logger.getLogger(TestDBOrder.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        
         private void testDelete() {
        System.out.print("OrderID: ");
        String orderID = in.nextLine();
        System.out.print("Date: ");
        String date = in.nextLine();
        
        try {
            if (db.checkOrders(orderID, date)) {
                db.deleteOrders(orderID);
            } else {
                System.out.println("Order does not exist.");
            }
        } catch (SQLException ex) { 
            Logger.getLogger(TestDBOrder.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void showALL() {
        try {
            ArrayList<Orders> Orders = db.fectOrders();
            System.out.println("ORDER TABLE: ");
            Orders.stream().forEach((orders) -> {
                System.out.printf("%-20s %-30s %-20s %-10s \n", orders.getorderID(), orders.getorderStatus(), orders.gettotalCost(), orders.getproductID(), orders.getquantity(), orders.getdate());  
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDBOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 

        
       
    




