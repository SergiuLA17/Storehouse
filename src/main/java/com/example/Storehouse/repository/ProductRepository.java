package com.example.Storehouse.repository;

import com.example.Storehouse.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Integer> {

    public Products findByName(String name);
}
