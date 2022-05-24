package com.example.storehouse;

import java.time.LocalDateTime;

public class Product {
    String nameOfProduct;
    int quantity;
    LocalDateTime dateOfManufacture;
    int daysToExpire;

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

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", quantity=" + quantity +
                ", dateOfManufacture=" + dateOfManufacture +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}
