package com.example.Storehouse.model.product;

public class ProductRequest {

    private final String name;
    private final int quantity;

    public ProductRequest(String name, int quantity) {

        this.name = name;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

