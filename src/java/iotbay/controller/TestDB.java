/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Products;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

 

public class TestDB {
private static Scanner in = new Scanner(System.in);
private DBConnector connector;
private Connection conn;
private DBManager db;

public static void main(String[] args) throws SQLException {
(new TestDB()).runQueries();
}

public TestDB(){
    try{
    connector = new DBConnector();
    conn = connector.openConnection();
    db = new DBManager(conn);
    } catch (ClassNotFoundException | SQLException ex){
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private char readChoice(){
    System.out.print("Operation CRUDS or * to exit: ");
    return in.nextLine().charAt(0);
}

private void runQueries() throws SQLException {
    char c;
    while ((c=readChoice()) != '*'){
        switch (c) {
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

private void testAdd(){
    System.out.print("Product id: ");
    int productId = Integer.parseInt(in.nextLine());
    System.out.print("Product name: ");
    String productName = in.nextLine();
    System.out.print("Product Description: ");
    String productDesc = in.nextLine();
    System.out.print("Product Cost: ");
    double productCost = Double.parseDouble(in.nextLine());
    System.out.print("Product Retail Price: ");
    double productRP = Double.parseDouble(in.nextLine());
    System.out.print("Product Stock: ");
    int productStock = Integer.parseInt(in.nextLine());
    try{
    db.addProduct(productId, productName, productDesc, productCost, productRP, productStock);
    } catch (SQLException ex){
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
    }
    System.out.println("User is added to the database.");
}
    
private void testRead() throws SQLException{
    System.out.print("Product id: ");
    int productId = Integer.parseInt(in.nextLine());
    System.out.print("Product name: ");
    String productName = in.nextLine();
    Products ProductwId = db.findProduct(productId);
    Products ProductwName = db.findProduct(productName);
    if (ProductwId != null){
        System.out.println("Product with id " + ProductwId.getProductId() + " aka " + ProductwId.getProductName() + " exists in the database");
    }
    else {
        System.out.println("a product with id " + productId + " doesn't exist");
    }
    if (ProductwName != null){
        System.out.println("Product with name " + ProductwName.getProductName() + " exists in the database");
    }
    else {
        System.out.println("a product with name " + productName + " doesn't exist");
    }
}

private void testUpdate(){
    System.out.print("Product id: ");
    int productId = Integer.parseInt(in.nextLine());
    System.out.print("Product name: ");
    String productName = in.nextLine();
    try{
        if(db.checkProducts(productId, productName)){
            System.out.print("Product Description: ");
            String productDesc = in.nextLine();
            System.out.print("Product Cost: ");
            double productCost = Double.parseDouble(in.nextLine());
            System.out.print("Product Retail Price: ");
            double productRP = Double.parseDouble(in.nextLine());
            System.out.print("Product Stock: ");
            int productStock = Integer.parseInt(in.nextLine());
            db.updateProduct(productId, productName, productDesc, productCost, productRP, productStock);
        }
        else{
            System.out.println("Product does not exist.");
        }
    }
    catch (SQLException ex){
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void testDelete(){
    System.out.print("Product id: ");
    int productId = Integer.parseInt(in.nextLine());
    System.out.print("Product name: ");
    String productName = in.nextLine();
    try{
        if(db.checkProducts(productId, productName)){
            db.deleteProduct(productId);
        } 
        else{
            System.out.println("Product does not exist.");
        }
    } catch(SQLException ex){
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void testDisplay(){
    try{
        ArrayList<Products> products = db.displayProducts();
        System.out.println("PRODUCT CATALOGUE: ");
        products.stream().forEach((product) -> {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-10s \n",product.getProductId(), product.getProductName(), product.getProductDescription(), product.getProductCost(), product.getProductRP(), product.getProductStock());
        });
        System.out.println();
    } catch(SQLException ex){
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}