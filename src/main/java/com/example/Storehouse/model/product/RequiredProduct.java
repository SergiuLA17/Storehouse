package com.example.Storehouse.model.product;

import com.example.Storehouse.entity.Products;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RequiredProduct {
    private Optional<Product> requiredProduct;

    public void set(Optional<Products> product, int quantity) {
        this.requiredProduct = Product.toModel(product, quantity);
    }

    public Optional<Product> get() {
        return requiredProduct;
    }
}
