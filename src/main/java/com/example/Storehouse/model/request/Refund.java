package com.example.Storehouse.model.request;

import com.example.Storehouse.model.product.Product;

public class Refund extends Request {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "RequestReturnProduct{" +
                "product=" + product +
                ", uuid=" + id +
                '}';
    }
}
