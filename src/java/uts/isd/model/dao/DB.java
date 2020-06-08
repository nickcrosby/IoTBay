/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;

/**
 *
 * @author eduardomoraza
 */
public abstract class DB {
    //make sure to changes this to the right Database <3 
    protected String URL = "jdbc:derby://localhost:1527/IoTBaydb";
    protected String db = "IoTBaydb";
    protected String dbuser = "IoTUser";
    protected String dbpass = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}


