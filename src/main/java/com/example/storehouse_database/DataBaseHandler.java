package com.example.storehouse_database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class DataBaseHandler extends DbUtil {


    public Product checkDesireProduct(String name) throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM `" +
                PropertiesUtil.get(DATA_BASE_NAME_KEY) + "`.`" +
                PropertiesUtil.get(TABLE_NAME_KEY) +
                "` WHERE `name`='" + name + "';";

        Statement statement = ConnectionManager.open().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);

        Product product = null;
        while (resultSet.next()) {
            product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    convertToLocalDateTime(resultSet.getDate(4), resultSet.getTime(4)),
                    resultSet.getInt(5));
        }
        return product;
    }

    public LocalDateTime convertToLocalDateTime(Date date, Time time) {
        return LocalDateTime.of(date.getYear() + 1900, date.getMonth() + 1, date.getDay() + 1, time.getHours(), time.getMinutes());
    }

    public void create_data_base(Connection dbConnection) throws IOException, SQLException {
        String scriptFilePath = "resources/create_database_and_table.sql";
        Statement statement;
        BufferedReader reader = null;

        try {
            statement = dbConnection.createStatement();
            reader = new BufferedReader(new FileReader(scriptFilePath));
            String line;

            while ((line = reader.readLine()) != null) {
                statement.execute(line);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
