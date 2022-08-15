package com.example.Storehouse.exception;

import com.example.Storehouse.exception.exceptions.NullOptionalException;
import com.example.Storehouse.exception.exceptions.ProductNotFoundException;
import com.example.Storehouse.exception.exceptions.ServerErrorException;
import com.example.Storehouse.exception.exceptions.WrongQuantityException;
import com.example.Storehouse.logger.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StoreHouseControllerAdvice {
    @Autowired
    Print print;

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException productNotFoundException) {
        print.error("Request processing error. " + productNotFoundException.getMessage() + "\n");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFoundException.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public void print(NullPointerException nullPointerException) {
        print.error(nullPointerException.getMessage());
    }

    @ExceptionHandler(WrongQuantityException.class)
    public ResponseEntity<Object> exception(WrongQuantityException wrongQuantityException) {
        print.error("Request processing error. " + wrongQuantityException.getMessage() + "\n");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(wrongQuantityException.getMessage());
    }

    @ExceptionHandler(NullOptionalException.class)
    public void exception() {
        print.error("Object is null");
    }

    @ExceptionHandler(ServerErrorException.class)
    public  ResponseEntity<Object> exception(ServerErrorException serverErrorException){
        return ResponseEntity.status(500).body("Oops looks like something went wrong.");
    }

}