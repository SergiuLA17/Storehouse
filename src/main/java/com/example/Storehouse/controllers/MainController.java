package com.example.Storehouse.controllers;
import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.ProductNotfoundException;
import com.example.Storehouse.model.Product;
import com.example.Storehouse.service.StorehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RestController
public class MainController {
    @Autowired
    private StorehouseService storehouseService;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping(path = "/getProduct")
    public ResponseEntity getProduct(@RequestParam("name") String name, @RequestParam("quantity") int quantity) {
        Products product = storehouseService.findByName(name);
        Products productForUpdate = storehouseService.findByName(name);
        logger.info("Request to purchase " + quantity + " kg of " + name);

        if (storehouseService.checkQuantityProduct(product, quantity)) {
            storehouseService.updateProductWhenPurchased(productForUpdate, quantity);
            try {
                return ResponseEntity.ok(Product.toModel(product, quantity));
            } catch (Exception e) {
                throw new ProductNotfoundException();
            }
        } else
            storehouseService.updateProductWhenProductNotFound(product);
        throw new ProductNotfoundException();
    }
}
