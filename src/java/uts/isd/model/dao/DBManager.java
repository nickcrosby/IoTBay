/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.Products;
import uts.isd.model.Payment;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.Customer;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

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

//Find Payment by PaymentID and Date in the database   
public Payment findPayment(int PaymentID, String Date) throws SQLException {       
       String fetch = "select * from IOTUSER.Payment where PAYMENTID = '" + PaymentID + "' and DATE='" + Date +  "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while (rs.next()) {
           int paymentPaymentID = rs.getInt(1);
           String paymentDate = rs.getString(5);
           if (PaymentID==PaymentID && paymentDate.equals(Date)) {
               String account_Name = rs.getString(2);
               int account_Number = rs.getInt(3);
               String payment_method = rs.getString(4);
               int total_amount = rs.getInt(6);
               String expDate = rs.getString(7);
               return new Payment(PaymentID, account_Name, account_Number, Date, payment_method, total_amount, expDate);
           }
       }
   return null;   
}

//Add payment-data into the database   
public void addPayment(int paymentID, String account_Name, int account_Number, String payment_Method, String date, String expDate) throws SQLException {                   //code for add-operation       
  st.executeUpdate("INSERT INTO IOTUSER.Payment " + "VALUES ('" + paymentID + "', '" + account_Name + "', '" + account_Number + "', '" + payment_Method +"', '" + date +"', '" + expDate + "')" );   
}

//update a payment details in the database   
public void updatePayment(String account_Name, String account_Number, String expDate) throws SQLException {       
  st.executeUpdate("INSERT INTO IOTUSER.Payment SET Account_Name-'" + account_Name + "', account_Number-'" + account_Number + "', EXP DATE'" + account_Number + "'" );   
}       

//delete a user from the database   
public void deletePayment(int account_Number) throws SQLException{       
    st.executeUpdate("DELETE FROM IOTUSER.Payment WHERE Account_Number='" + account_Number + "'");
}

//Read all Payments made
public ArrayList<Payment> fectPayment() throws SQLException {
    String fetch = "select * from PAYMENT";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Payment> temp = new ArrayList();
    
    while (rs.next()) {
        int paymentID = rs.getInt(1);
        String account_Name = rs.getString(2);
        int account_Number = rs.getInt(3);
        String payment_Method = rs.getString(4);
        String date = rs.getString(5);
        int total_amount = rs.getInt(6);
        String expDate = rs.getString(7);
        temp.add(new Payment(paymentID, account_Name, account_Number, payment_Method, date, total_amount, expDate));
    }
    return temp;
}

//Verify if there is a Payment made with the accountname and account number
public boolean checkPayment (String account_Name, int account_Number) throws SQLException {
    String fetch = "select * from IOTUSER.Payment where Account_Name= '" + account_Name + "' and Account_Number='" + account_Number + "'";
    ResultSet rs = st.executeQuery(fetch);
    while (rs.next()) {
        String Account_Name = rs.getString(2);
        int Account_Number = rs.getInt(3);
        if (Account_Name.equals(account_Name) && account_Number==Account_Number){
            return true;
        }
    }
    return false;
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