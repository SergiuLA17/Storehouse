package com.example.storehouse;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class DateBaseHandler extends ConnectToProductsDB {
    Connection dbConnection;
    static ArrayList<Product> products = new ArrayList<>();

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + Const.DB_NAME;

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
        String insert = "SELECT * FROM " + Const.DB_NAME + "." + Const.PRODUCT_TABLE + ";";

        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int price = resultSet.getInt(3);
            System.out.printf("%d. %s - %d \n", id, name, price);
        }
    }

    public Boolean chekDesireProduct(String name, String quantity_need) throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM `" + Const.DB_NAME + "`.`" + Const.PRODUCT_TABLE + "` WHERE `name`='" + name + "';";

        Statement statement = getDbConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(insert);
        Date date;
        Time time;

        while (resultSet.next()) {
            date = resultSet.getDate(4);
            time = resultSet.getTime(4);

            Product product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    convertToLocalDateTime(date, time),
                    resultSet.getInt(5));

            products.add(product);


            System.out.printf(String.valueOf(product));
        }
        return !products.isEmpty();
    }

    public LocalDateTime convertToLocalDateTime(Date date, Time time) {
        return LocalDateTime.of(date.getYear()+1900, date.getMonth()+1, date.getDay()+1, time.getHours(), time.getMinutes());
    }
}
