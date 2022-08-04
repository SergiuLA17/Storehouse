package com.example.Storehouse.model.request;

import com.example.Storehouse.model.product.ProductRequest;

import java.util.ArrayList;
import java.util.UUID;

public class RequestMultiProducts extends Request {
    private ArrayList<ProductRequest> products;

    public RequestMultiProducts(UUID id, ArrayList<ProductRequest> products) {
        this.id = id;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<ProductRequest> getProducts() {
        return products;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProducts(ArrayList<ProductRequest> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}

