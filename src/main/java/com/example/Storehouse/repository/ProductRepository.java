package com.example.Storehouse.repository;

import com.example.Storehouse.entity.Products;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Products, Integer> {
    Optional<Products> findByName(String name);

}
