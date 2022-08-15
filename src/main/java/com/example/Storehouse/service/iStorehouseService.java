package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;

import java.util.Optional;

public interface iStorehouseService {
    void updateDataBase(String name, int quantity);
    Optional<Products> findByName(String name);
    void updateQuantityProduct(String name);
    void saveRefundProduct(RefundProducts product);
    int getQuantityOfProduct(String name);
}
