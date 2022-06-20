package com.example.Storehouse.controllers;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.ProductNotfoundException;
import com.example.Storehouse.model.Product;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
public class MainController {
    @Autowired
    private StorehouseService storehouseService;

    @GetMapping(path = "/getProduct")
    public ResponseEntity getProduct(@RequestParam("name") String name) {
        Products product = storehouseService.findByName(name);

        try {
            return ResponseEntity.ok(Product.toModel(product));
        } catch (Exception e) {
            throw new ProductNotfoundException();
        }
    }
}
