package com.example.storehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToProductsDB {

    static final String DB_URL = "jdbc:mysql://localhost:3036/Storehouse";
    static final String USER = "root";
    static final String PASS = "madrid12";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connect = null;
        connect = DriverManager.getConnection(DB_URL, USER, PASS);

        if (connect != null) {
            System.out.println("Successfully connected to MySQL database ");

        }


    }
}
