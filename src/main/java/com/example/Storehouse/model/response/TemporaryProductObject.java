package com.example.Storehouse.model.response;

import com.example.Storehouse.entity.Products;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TemporaryProductObject {
    private Optional<Products> tempProduct;

    public void set(Optional<Products> product) {
        this.tempProduct = product;;
    }

    public Optional<Products> get() {
        return tempProduct;
    }

}
