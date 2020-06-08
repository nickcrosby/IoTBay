package uts.isd.model.dao;

import java.sql.Connection;

/**
 *
 * @author Karl Silis
 */
public abstract class DB {
    //make sure to changes this to the right Database <3 
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "iotdb";
    protected String dbuser = "iotuser";
    protected String dbpass = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}