package com.example.Storehouse.service;

import com.example.Storehouse.controllers.MainController;
import com.example.Storehouse.repository.ProductRepository;
import com.example.Storehouse.entity.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class StorehouseService {
    @Autowired
    private ProductRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    public Products findByName(String productName) {
        return productRepository.findByName(productName);
    }

    public void updateProductWhenPurchased(Products product, int quantity) {
        Optional<Products> products = findOne(product.getIdProduct());
        products.ifPresent(value -> value.setQuantity(value.getQuantity() - quantity));
        products.ifPresent(value -> productRepository.save(value));

    }

    public Boolean checkQuantityProduct(Products products, int quantity){
        return  products.getQuantity() > quantity;
    }

    public void updateProductWhenProductNotFound(Products product) {
        Optional<Products> products = findOne(product.getIdProduct());
        products.ifPresent(value -> value.setQuantity(200 + (int) (Math.random() * 500)));
        products.ifPresent(value -> logger.info("Product <" + value.getNameOfProduct() + "> is over, loading more. Now in store is " + value.getQuantity() + " kg"));
        products.ifPresent(value -> productRepository.save(value));
    }


    public Optional<Products> findOne(int id) {
        return productRepository.findById(id);
    }

}
