package com.example.storehouse;

import java.time.LocalDateTime;
import java.util.Date;

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

    @Override
    public String toString() {
        return "Product{" +
                ", ID=" + idProduct +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", quantity=" + quantity +
                ", dateOfManufacture=" + dateOfManufacture +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}
