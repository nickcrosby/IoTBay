package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Staff;
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

    public TestDB() {

        try {

            connector = new DBConnector();

            conn = connector.openConnection();

            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("Operations: (C/R/U/D/S/*): ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;

        while ((c = readChoice()) != '*') {
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
                    showAll();
                    break;
                default:
                    System.out.println("Command not recognised, please try again. ");
            }
        }
    }

    private void testAdd() {
        System.out.println("Email: ");
        String email = in.nextLine();

        System.out.println("First Name: ");
        String firstname = in.nextLine();

        System.out.println("Last Name: ");
        String lastname = in.nextLine();

        System.out.println("Password: ");
        String password = in.nextLine();

        System.out.println("Workphone: ");
        String workphone = in.nextLine();

        try {
            db.addStaff(email, firstname, lastname, password, workphone);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Staff Memeber has been successfully added to database");
    }

    private void testRead() throws SQLException {
        System.out.println("Email: ");
        String email = in.nextLine();

        System.out.println("Password: ");
        String password = in.nextLine();

        Staff staff = db.findStaff(email, password);

        if (staff != null) {
            System.out.println("Staff " + staff.getFname() + "exits in the database");
        } else {
            System.out.println("Staff member does not exist. ");
        }
    }

    private void testUpdate() {
        System.out.println("Email: ");
        String email = in.nextLine();

        System.out.println("Password: ");
        String password = in.nextLine();

        try {
            if (db.checkStaff(email, password)) {
                System.out.println("First Name: ");
                String firstname = in.nextLine();

                System.out.println("Workphone: ");
                String workphone = in.nextLine();
                db.updateStaff(email, firstname, firstname, password, workphone);
            } else {
                System.out.print("Staff member does not exist. ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testDelete() {
        System.out.println("Email: ");
        String email = in.nextLine();

        System.out.println("Password: ");
        String password = in.nextLine();

        try {
            if (db.checkStaff(email, password)) {
                db.deleteStaff(email);
            } else {
                System.out.print("Staff member does not exist. ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAll() {
        try {
            ArrayList<Staff> staffMember = db.fetchStaff();
            System.out.println("STAFF MEMBERS TABLE: ");
            staffMember.stream().forEach((staff) -> {
                System.out.printf("%-20s %-30s %-20s %-10s \n", staff.getEmail(), staff.getFname(), staff.getLname(), staff.getPassword());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
