package com.example.storehouse_database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class DateBaseHandler extends DbUtil {
    public static Product product = null;
    Connection dbConnection;
    public static ArrayList<Product> products = new ArrayList<>();

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + UtilConst.DB_NAME;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void addProductsInStore(String productName, String quantity, String dayToExpire) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO `" + 
                UtilConst.DB_NAME + "`.`" +
                UtilConst.PRODUCT_TABLE + "` (`" +
                UtilConst.PRODUCTS_NAME + "`, `" +
                UtilConst.PRODUCTS_QUANTITY + "`, `" +
                UtilConst.PRODUCTS_DATEOFMANUFACTURE + "`, `" +
                UtilConst.PRODUCTS_DATETOEXPIRE + "`) " +
                "VALUES (?, ?, ?,?);";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, productName);
        prSt.setString(2, quantity);
        prSt.setString(3, String.valueOf(LocalDateTime.now()));
        prSt.setString(4, dayToExpire);
        prSt.execute();

    }

    public void checkDesireProduct(String name) throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM `" +
                UtilConst.DB_NAME + "`.`" +
                UtilConst.PRODUCT_TABLE + "` WHERE `name`='" + name + "';";

        products.clear();
        Statement statement = getDbConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(insert);
        Date date;
        Time time;

        while (resultSet.next()) {
            date = resultSet.getDate(4);
            time = resultSet.getTime(4);

            product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    convertToLocalDateTime(date, time),
                    resultSet.getInt(5));
        }
    }

    public LocalDateTime convertToLocalDateTime(Date date, Time time) {
        return LocalDateTime.of(date.getYear() + 1900, date.getMonth() + 1, date.getDay() + 1, time.getHours(), time.getMinutes());
    }

}
