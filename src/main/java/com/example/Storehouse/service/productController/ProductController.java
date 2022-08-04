package com.example.Storehouse.service.productController;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.model.product.Product;
import com.example.Storehouse.model.product.RequiredProduct;
import com.example.Storehouse.model.response.TemporaryProductObject;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductController implements iProductController {
    @Autowired
    private RequiredProduct requiredProduct;
    @Autowired
    private TemporaryProductObject temptObject;
    @Autowired
    private ProductPreparation productPreparation;

    public StorehouseService setRequiredProduct(Optional<Products> product, int quantity, StorehouseService service) {
        requiredProduct.set(product, quantity);
        return service;
    }

    public ProductPreparation productPreparation() {
        return productPreparation;
    }

    public Optional<Product> getRequiredProduct() {
        return requiredProduct.get();
    }

    public StorehouseService setTemptProductObject(Optional<Products> product, StorehouseService service) {
        temptObject.set(product);
        return service;
    }

    public Optional<Products> getTemptProductObj() {
        return temptObject.get();
    }

}
