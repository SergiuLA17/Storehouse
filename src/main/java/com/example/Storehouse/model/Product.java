package com.example.Storehouse.model;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class Product {
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;
    @Autowired
    private StorehouseService storehouseService;
    public static Product toModel(Products products, int quantity) {
        Product model = new Product();
        model.setName(products.getNameOfProduct());
        model.setQuantity(quantity);
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