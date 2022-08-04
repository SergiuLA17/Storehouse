package com.example.Storehouse.service.productController;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.model.product.Product;
import com.example.Storehouse.service.StorehouseService;

import java.util.Optional;

public interface iProductController {
    StorehouseService setRequiredProduct(Optional<Products> product, int quantity, StorehouseService service);
    Optional<Product> getRequiredProduct();
    StorehouseService setTemptProductObject(Optional<Products> product, StorehouseService service);
    Optional<Products> getTemptProductObj();
    ProductPreparation productPreparation();
}
