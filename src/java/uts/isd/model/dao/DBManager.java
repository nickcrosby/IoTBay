package uts.isd.model.dao;

import uts.isd.model.Customer;
import java.sql.*;

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
    public Customer findUser(String firstName, String lastName, String email, String password, String workPhone) throws SQLException {
        //setup the select sql query string       
        String fetch = "select * from IOTCUSTOMER.Staff where FirstName = '" + firstName + "'LastName = '" + lastName + "'email= '" + email + "'Password = '" + password + "'workPhone= '" + workPhone;

        //execute this query using the statement field 
        ResultSet rs = st.executeQuery(fetch);

        //add the results to a ResultSet       
        while (rs.next()) {
            String customerEmail = rs.getString(2);
            String customerPass = rs.getString(3);
            if (customerEmail.equals(email) && customerPass.equals(password)) {
                String customerFirstName = rs.getString(1);
                String customerLastName = rs.getString(4);
            }
        }
        //search the ResultSet for a user using the parameters               
        return null;
    }

//Add a user-data into the database   
    public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException {//code for add-operation       
        st.executeUpdate("INSERT INTO Customer.Staff" + "VALUES ('" + "'), ");
    }

//update a user details in the database   
    public void updateUser(String email, String name, String password, String gender, String favcol) throws SQLException {
        //code for update-operation   
    }

//delete a user from the database   
    public void deleteUser(String email) throws SQLException {
        //code for delete-operation   
    }
}
