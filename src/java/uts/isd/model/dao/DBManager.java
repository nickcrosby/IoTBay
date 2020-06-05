package uts.isd.model.dao;

import uts.isd.model.Staff;
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
    public Staff findStaff(String email, String password) throws SQLException {
        //setup the select sql query string       
        String fetch = "select * from ADMINISTRATOR.Staff where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";

        //execute this query using the statement field 
        ResultSet rs = st.executeQuery(fetch);

        //add the results to a ResultSet       
        while (rs.next()) {
            String staffEmail = rs.getString(1);
            String staffPassword = rs.getString(4);
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                String staffFirstName = rs.getString(2);
                String staffLastName = rs.getString(3);
                return new Staff(staffFirstName, staffLastName, password);
            }
        }
        //search the ResultSet for a user using the parameters               
        return null;
    }

//Add a user-data into the database   
    public void addStaff(String email, String firstname, String lastname, String password, String workphone) throws SQLException {//code for add-operation       
        st.executeUpdate("INSERT INTO ADMINISTRATOR.Staff " + "VALUES ('" + email + "', '" + firstname + "', '" + lastname + "', '" + password + "' , '" + workphone + "'");
    }

//update a user details in the database   
    public void updateStaff(String email, String firstname, String lastname, String password, String workphone) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE ADMINISTRATOR.Staff SET NAME = '" + email + "', FIRSTNAME = '" + firstname + "', LASTNAME = '" + lastname + "', PASSWORD = '" + password + "', WORKPHONE = '" + workphone + "'");
    }

//delete a user from the database   
    public void deleteStaff(String firstname) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM ADMINISTRATOR.Staff WHERE FIRSTNAME = '" + firstname + "'");
    }

    public ArrayList<Staff> fetchStaff() throws SQLException {
        String fetch = "select * from STAFF";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while (rs.next()) {
            String email = rs.getString(1);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String password = rs.getString(4);
            String workphone = rs.getString(5);
            temp.add(new Staff(email, firstname, lastname, password, workphone));
        }
        return temp;
    }

    public boolean checkStaff(String email, String password) throws SQLException {
        String fetch = "select * from ADMINISTRATOR.Staff where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmail = rs.getString(2);
            String staffPassword = rs.getString(3);
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
