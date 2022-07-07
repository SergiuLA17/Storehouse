package com.example.Storehouse.exception;

import com.example.Storehouse.entity.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception() {

        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}