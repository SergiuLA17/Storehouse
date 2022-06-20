package com.example.Storehouse.controllers;

import com.example.Storehouse.exception.ProductNoFoundException;
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
    public ResponseEntity getProduct(@RequestParam("name") String name)  {
        try {
            return ResponseEntity.ok(storehouseService.getProductByName(name));
        } catch (ProductNoFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
