package com.example.storehouse;

import java.sql.*;
import java.time.LocalDateTime;

public class DateBaseHandler extends ConnectToProductsDB {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/Storehouse";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void addProductsInStore(String productName, String quantity, String dayToExpire) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO `" + Const.DB_NAME + "`.`" +
                Const.PRODUCT_TABLE + "` (`" +
                Const.PRODUCTS_NAME + "`, `" +
                Const.PRODUCTS_QUANTITY + "`, `" +
                Const.PRODUCTS_DATEOFMANUFACTURE + "`, `" +
                Const.PRODUCTS_DATETOEXPIRE + "`) " +
                "VALUES (?, ?, ?,?);";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, productName);
        prSt.setString(2, quantity);
        prSt.setString(3, String.valueOf(LocalDateTime.now()));
        prSt.setString(4, dayToExpire);
        prSt.execute();

    }

    public void getInfoAboutStore() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM Storehouse.Products;";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Storehouse.Products;");
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int price = resultSet.getInt(3);
            System.out.printf("%d. %s - %d \n", id, name, price);
        }
    }
}
