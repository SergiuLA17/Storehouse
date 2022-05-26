package com.example.storehouse;

import java.sql.SQLException;
import java.util.Scanner;

public class AddProductToDataBase {
    static Scanner scanner = new Scanner(System.in);
    static DateBaseHandler dateBaseHandler = new DateBaseHandler();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       //addProductInStore();
        checkDesireProduct();
    }

    public static void addProductInStore() throws SQLException, ClassNotFoundException {

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
    private static void checkDesireProduct() throws SQLException, ClassNotFoundException {
        String name;
        String quatnity;

        System.out.println("Input desire product!");
        System.out.println("Name : ");
        name = scanner.nextLine();

        System.out.println("Quantity: ");
        quatnity = scanner.nextLine();

        if(dateBaseHandler.chekDesireProduct(name,quatnity)){
            System.out.println("\n" + "We have product!");
        }else
            System.out.println("Sorry!");

    }

}
