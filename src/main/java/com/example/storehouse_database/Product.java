package com.example.storehouse_database;

import java.time.LocalDateTime;

public class Product {
    int idProduct;
    String nameOfProduct;
    int quantity;
    LocalDateTime dateOfManufacture;
    int daysToExpire;

    public Product(int idProduct, String nameOfProduct, int quantity, LocalDateTime dateOfManufacture, int daysToExpire) {
        this.idProduct = idProduct;
        this.nameOfProduct = nameOfProduct;
        this.quantity = quantity;
        this.dateOfManufacture = dateOfManufacture;
        this.daysToExpire = daysToExpire;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateOfManufacture() {
        return dateOfManufacture;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDateOfManufacture(LocalDateTime dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String productNoFound() {
        return "Sorry, product wasn't found!";
    }

    @Override
    public String toString() {
        return "<p>" + "Product :" + "</p>" +
                "<p>" + "Name = " + nameOfProduct +  "</p>" +
                "<p>" + "Quantity = " + quantity + "</p>" +
                "<p>" + "Date of manufacture = "
                + dateOfManufacture.getYear() + "-"
                + dateOfManufacture.getMonth() + "-"
                + dateOfManufacture.getDayOfMonth() + " Time: "
                + dateOfManufacture.getHour() + ":"+
                + dateOfManufacture.getMinute() +  "</p>" +
                "<p>" + "Days to expire = " + daysToExpire + "</p>";
    }
}
