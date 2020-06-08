/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

 

public class TestDB {
private static Scanner in = new Scanner(System.in);

public static void main(String[] args) {
try {
DBConnector connector = new DBConnector();
Connection conn = connector.openConnection();
DBManager db = new DBManager(conn);

//Products
System.out.print("Product id: ");
String email = in.nextLine();
System.out.print("Product name: ");
String name = in.nextLine();
System.out.print("User password: ");
String password = in.nextLine();
System.out.print("User gender: ");
String gender = in.nextLine();
System.out.print("User favorite color: ");
String favcol = in.nextLine();
//db.addProduct(productId, productName, productDesc, productCost, productRP, productStock);
System.out.println("User is added to the database.");
//Products

connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

}

}

}