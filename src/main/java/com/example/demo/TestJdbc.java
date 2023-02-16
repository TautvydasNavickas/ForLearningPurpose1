package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args){

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/?user=hbstudent";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
