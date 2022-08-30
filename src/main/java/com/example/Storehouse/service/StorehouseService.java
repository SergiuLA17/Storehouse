package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.exception.exceptions.ProductNotFoundException;
import com.example.Storehouse.service.logger.LoggerService;
import com.example.Storehouse.repository.ProductRepository;
import com.example.Storehouse.repository.RefundProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorehouseService implements iStorehouseService{
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private ProductRepository repository;
    @Autowired
    private RefundProductRepository refundRepository;

    public void updateDataBase(String name, int quantity) {
        final Optional<Products> product = findByName(name);
        product.get().setQuantity(product.get().getQuantity() - quantity);
        repository.save(product.get());
    }

    public Optional<Products> findByName(String name) {
         final Optional<Products> product = repository.findByName(name);
        if (product.isPresent()) {
            return product;
        } else {
            throw new ProductNotFoundException("No found product or wrong name, Request product name: " + name);
        }
    }

    public void updateQuantityProduct(String name) {
        final Optional<Products> product = findByName(name);
        if (product.isPresent()) {
            product.get().setQuantity(500);
            loggerService.info(name + " quantity has been update, now quantity of " + name + " equal to 500");
            repository.save(product.get());
        } else {
            throw new ProductNotFoundException("No found product or wrong name, Request product name: " + name);

        }
    }

    public void saveRefundProduct(RefundProducts product) {
        refundRepository.save(product);
    }

    public int getQuantityOfProduct(String name){
        final Optional<Products> product = findByName(name);
        if(product.isPresent()){
            return product.get().getQuantity();
        }else
            throw new ProductNotFoundException("No found product or wrong name, Request product name: " + name);
    }
}

