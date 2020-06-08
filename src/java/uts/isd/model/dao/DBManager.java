/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;



import uts.isd.model.Orders;
import java.sql.*;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Orders;

/**
 *
 * @author eduardomoraza
 */

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   

 

public Orders findOrders(String orderID, String date) throws SQLException {       
    String fetch = "select * from IOTUSER.Order_T where ORDERID = '" + orderID + "' and DATE ='" + date + "'";
   ResultSet rs = st.executeQuery(fetch);
   
   while (rs.next()) {
    String ordersorderID = rs.getString(1);
    String ordersdate = rs.getString(6);
    if (ordersorderID.equals(orderID) && ordersdate.equals(date)) {
          String ordersorderStatus = rs.getString(2);
          String orderstotalCost = rs.getString(3);
          String ordersproductID = rs.getString(4);
          String ordersquantity = rs.getString(5);
        }
    }
   
                 
   return null;    
}

//Add a user-data into the database   
public void addOrders(String orderID, String orderStatus, String totalCost, String productID, String quantity, String date) throws SQLException {                   //code for add-operation       
  st.executeUpdate("INSERT INTO IOTUSER.Order_t " + "VALUES ('" + orderID + "', '" + orderStatus + "', '" + totalCost + "', '" + productID + "', '" + quantity + "', '" + date + "')");   


}

//update a user details in the database   

public void updateOrders(String orderID, String orderStatus, String totalCost, String productID, String quantity, String date) throws SQLException {       
   st.executeUpdate("UPDATE IOTUSER.Order_T SET ORDERID='" + orderID + "', ORDERSTATUS='" + orderStatus + "', TOTALCOST='" + totalCost + "', PRODUCTID='" + productID + "', QUANTITY='" + quantity + "' WHERE DATE='" + date + "'");  


}       







public void deleteOrders(String productID) throws SQLException{       
    st.executeUpdate("DELETE FROM IOTUSER.Order_T WHERE PRODUCTID='" + productID + "'");

}

public ArrayList<Orders> fectOrders() throws SQLException {
    String fetch = "select * from ORDER_T";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Orders> temp = new ArrayList();
    
    while (rs.next()){
        String orderID = rs.getString(1);
        String orderStatus = rs.getString(2);
        String totalCost = rs.getString(3);
        String productID = rs.getString(4);
        String quantity = rs.getString(5);
        String date = rs.getString(6);
        temp.add(new Orders (orderID, orderStatus, totalCost, productID, quantity, date));
    }
    return temp;
}
  
public boolean checkOrders (String orderID, String date) throws SQLException {
    String fetch = "select * from IOTUSER.Order_T where ORDERID = '" + orderID + "' and DATE='" + date + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while (rs.next()) {
        String ordersorderID = rs.getString(1);
        String ordersdate = rs.getString(6);
        if (ordersorderID.equals(orderID) && ordersdate.equals(date)) {
            return true;
        }
    }
    return false;
}
        
}




