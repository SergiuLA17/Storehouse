package com.example.Storehouse.model;

import com.example.Storehouse.entity.Products;

import java.time.LocalDateTime;

public class Product {
    private  String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;

    public static Product toModel(Products products){
        Product model = new Product();
        model.setName(products.getNameOfProduct());
        model.setQuantity(products.getQuantity());
        model.setDateOfManufacture(products.getDateOfManufacture());
        model.setDaysToExpire(products.getDaysToExpire());
        return model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDateTime dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }


}
