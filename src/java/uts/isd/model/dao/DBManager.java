/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;


import uts.isd.model.Products;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Products findProduct(String ProductName) throws SQLException {       
   String fetch = "select * from IOTUSER.PRODUCTS where PRODUCTNAME='" + ProductName + "'";
   ResultSet rs = st.executeQuery(fetch);
while (rs.next())   {
    String productName = rs.getString(2);
    //PRODUCTID, PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCOST,PRODUCTRETAILPRICE, PRODUCTSTOCK
    if(productName.equals(ProductName)) {
        int productId = rs.getInt(1);
        String productDesc = rs.getString(3);
        double productCost = rs.getDouble(4);
        double productRP = rs.getDouble(5);
        int productStock = rs.getInt(6);
        return new Products(productId, productName, productDesc, productCost, productRP, productStock);
    }
    
}
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters               
   return null;
}
public Products findProduct(int ProductId) throws SQLException {       
   String fetch = "select * from IOTUSER.PRODUCTS where PRODUCTID='" + ProductId + "'";
   ResultSet rs = st.executeQuery(fetch);
while (rs.next())   {
    int productId = rs.getInt(1);
    //PRODUCTID, PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCOST,PRODUCTRETAILPRICE, PRODUCTSTOCK
    if(productId==ProductId) {
        String productName = rs.getString(2);
        String productDesc = rs.getString(3);
        double productCost = rs.getDouble(4);
        double productRP = rs.getDouble(5);
        int productStock = rs.getInt(6);
        return new Products(productId, productName, productDesc, productCost, productRP, productStock);
    }
}
   return null;
}

//Add a user-data into the database   
public void addProduct(int productId, String productName, String productDesc, double productCost, double productRP, int productStock) throws SQLException {               
  st.executeUpdate("INSERT INTO IOTUSER.PRODUCTS " + "VALUES ('" + productId + "', '" + productName + "', '" + productDesc + "', '" + productCost + "', '" + productRP + "', '" + productStock + "')");   

}

//update a user details in the database   
public void updateProduct(int productId, String productName, String productDesc, double productCost, double productRP, int productStock) throws SQLException {       
   st.executeUpdate("UPDATE IOTUSER.PRODUCTS SET PRODUCTNAME='" + productName + "',PRODUCTDESCRIPTION='" + productDesc + "',PRODUCTCOST='" + productCost + "',PRODUCTRETAILPRICE='" + productRP + "',PRODUCTSTOCK='" + productStock + "'WHERE PRODUCTID='" + productId + "'");
}       

//delete a user from the database   
public void deleteProduct(String email) throws SQLException{       
   //code for delete-operation   

}


}