package com.example.Storehouse.model.product;

import com.example.Storehouse.entity.Products;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class Product {
    @JsonDeserialize
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;


    public static Optional<Product> toModel(Optional<Products> products, int quantity) {
        if(!products.isPresent()){
            return Optional.empty();
        }
        Optional<Product> model = Optional.of(new Product());
        model.get().setName(products.get().getNameOfProduct());
        model.get().setQuantity(quantity);
        model.get().setDateOfManufacture(products.get().getDateOfManufacture());
        model.get().setDaysToExpire(products.get().getDaysToExpire());
        return model;
    }

    public Product() {
    }

    public Product(String name, int quantity, LocalDateTime dateOfManufacture, int daysToExpire) {
        this.name = name;
        this.quantity = quantity;
        this.dateOfManufacture = dateOfManufacture;
        this.daysToExpire = daysToExpire;
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

    @Override
    public String toString() {
        return "Product{" +
                " name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dateOfManufacture=" + dateOfManufacture +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}