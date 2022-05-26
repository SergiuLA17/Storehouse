package com.example.storehouse;

import java.sql.SQLException;
import java.util.Scanner;

public class AddProductToDataBase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        DateBaseHandler dateBaseHandler = new DateBaseHandler();
        String nameOfproduct;
        String quantity;
        String dayToExpire;
        System.out.println("Add product to store");
        System.out.println("Enter name of product: ");
        nameOfproduct = scanner.nextLine();
        System.out.println("Enter quantity: ");
        quantity = scanner.nextLine();
        System.out.println("Enter days to expire: ");
        dayToExpire = scanner.nextLine();
        dateBaseHandler.addProductsInStore(nameOfproduct, quantity, dayToExpire);
        dateBaseHandler.getInfoAboutStore();
        System.out.println("Product: " + nameOfproduct + "\n" +
                "quantity: " + quantity + "\n" +
                "days to expire: " + dayToExpire + "\n" +
                "was added succesfully!");
    }
}
