/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;


import uts.isd.model.Products;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}
  
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

//Add a product into the database   
public void addProduct(int productId, String productName, String productDesc, double productCost, double productRP, int productStock) throws SQLException {               
  st.executeUpdate("INSERT INTO IOTUSER.PRODUCTS " + "VALUES ('" + productId + "', '" + productName + "', '" + productDesc + "', '" + productCost + "', '" + productRP + "', '" + productStock + "')");   

}

//update a products details in the database   
public void updateProduct(int productId, String productName, String productDesc, double productCost, double productRP, int productStock) throws SQLException {       
   st.executeUpdate("UPDATE IOTUSER.PRODUCTS SET PRODUCTNAME='" + productName + "',PRODUCTDESCRIPTION='" + productDesc + "',PRODUCTCOST='" + productCost + "',PRODUCTRETAILPRICE='" + productRP + "',PRODUCTSTOCK='" + productStock + "'WHERE PRODUCTID='" + productId + "'");
}       

//delete a product from the database   
public void deleteProduct(int productId) throws SQLException{       
   st. executeUpdate("DELETE FROM IOTUSER.PRODUCTS WHERE PRODUCTID='" + productId + "'");
}

public ArrayList<Products> displayProducts() throws SQLException {
    String fetch ="select * from IOTUSER.PRODUCTS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Products> temp = new ArrayList();
    
    while(rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String desc = rs.getString(3);
        double cost = rs.getDouble(4);
        double rp = rs.getDouble(5);
        int stock = rs.getInt(6);
        temp.add(new Products(id,name,desc,cost,rp,stock));
    }
    return temp;
}

public boolean checkProducts(int productId, String productName)throws SQLException{
    String fetch = "select * from IOTUSER.PRODUCTS where PRODUCTID = '" + productId + "' and  PRODUCTNAME='" + productName + "'";
    ResultSet rs = st.executeQuery(fetch);
    while (rs.next()){
        int ProductId = rs.getInt(1);
        String ProductName = rs.getString(2);
        if(ProductId==productId && ProductName.equals(productName))
        {
            return true;
        }
    }
    return false;
}
}