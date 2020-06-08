/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author eduardomoraza
 */
public class TestDB {
  private static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) throws SQLException {
    try {
    DBConnector connector = new DBConnector();
    Connection conn = connector.openConnection();
    DBManager db = new DBManager(conn);
 
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
    db.addOrders( orderID, orderStatus, totalCost, productID, quantity, date);
    System.out.println("Order is added to the database.");
    connector.closeConnection();
 
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}




