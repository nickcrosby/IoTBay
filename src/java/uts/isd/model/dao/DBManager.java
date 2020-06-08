/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;


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

//Find user by email and password in the database   
public Customer findCustomer(String email, String password) throws SQLException {       
   //setup the select sql query string       
   //execute this query using the statement field       
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters               
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

}
