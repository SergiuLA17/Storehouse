package com.example.Storehouse.controllers;

import com.example.Storehouse.hendler.StorehouseHandler;
import com.example.Storehouse.model.product.RequiredProducts;
import com.example.Storehouse.model.request.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RestController
public class MainController {
    @Autowired
    private StorehouseHandler handler;


    @GetMapping(path = "/getProduct")
    public ResponseEntity<?> getProductAndQuantity(@RequestParam("idRequest") UUID id, @RequestParam("name") String name, @RequestParam("quantity") int quantity) {
        return handler.response(name, quantity, id);
    }

    @PostMapping("/getMultipleProducts")
    @ResponseBody
    public ResponseEntity<?> buyMultiProducts(@RequestBody(required = false) RequiredProducts request) {
        return handler.response(request);
    }

    @GetMapping(path = "/getQuantity")
    public ResponseEntity<?> checkQuantityOfProduct(@RequestParam("idRequest") UUID id, @RequestParam("name") String name) {
        return handler.response(name, id);
    }

    @PostMapping("/returnProduct")
    @ResponseBody
    public ResponseEntity<?> getReturnedProduct(@RequestBody(required = false) Refund request) {
        return handler.response(request);
    }
}

