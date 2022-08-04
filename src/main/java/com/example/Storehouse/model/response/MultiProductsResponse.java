package com.example.Storehouse.model.response;

import com.example.Storehouse.model.product.Product;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class MultiProductsResponse extends Response {
    private final ArrayList<Product> products = new ArrayList<>();

    public MultiProductsResponse() {
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public MultiProductsResponse setId(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public StorehouseService setProducts(Product product, StorehouseService service) {
        products.add(product);
        return service;

    }

    @Override
    public String toString() {
        return "{" +
                "idRequest=" + uuid +
                ", products=" + products +
                '}';
    }
}
