package com.example.Storehouse.service;

import com.example.Storehouse.model.Product;
import com.example.Storehouse.repository.ProductRepository;
import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.ProductNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorehouseService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductByName(String productName) throws ProductNoFoundException {
        Products product = productRepository.findByName(productName);
        if(product == null){
            throw new ProductNoFoundException("Product doesn't found");
        }
        return Product.toModel(product);
    }

}
