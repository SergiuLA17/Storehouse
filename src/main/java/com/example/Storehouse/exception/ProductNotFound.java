package com.example.Storehouse.exception;

import com.example.Storehouse.service.StorehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotFound {
    @ExceptionHandler(value = ProductNotfoundException.class)

    public void response(StorehouseService service, String name) {
        service.print().error("Product not found or wrong product name: " + name, service);
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or wrong product name. " +
                "Request name product: " + name);
    }
}
