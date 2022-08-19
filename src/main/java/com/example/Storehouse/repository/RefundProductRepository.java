package com.example.Storehouse.repository;

import com.example.Storehouse.entity.RefundProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundProductRepository extends CrudRepository<RefundProducts, Integer> {
}
