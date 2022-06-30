package com.example.Storehouse.service;

import com.example.Storehouse.repository.ProductRepository;
import com.example.Storehouse.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorehouseService {
    @Autowired
    private ProductRepository productRepository;

    public Products findByName(String productName) {
        return productRepository.findByName(productName);
    }

}
