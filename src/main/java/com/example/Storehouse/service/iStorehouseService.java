package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.model.request.Refund;
import com.example.Storehouse.service.print.Print;
import com.example.Storehouse.service.productController.ProductController;
import com.example.Storehouse.service.productController.ProductPreparation;
import com.example.Storehouse.service.productReadinessStatus.StatusProduct;
import com.example.Storehouse.service.responseController.ResponseController;

import java.util.Optional;

public interface iStorehouseService {
    ProductController productController();

    StatusProduct statusApproved();

    Print print();

    ProductPreparation preparationProductForResponse();

    ResponseController responseController();

    StorehouseService updateProductWhenPurchased(Optional<Products> product, int quantity);

    boolean checkQuantityProduct(Optional<Products> products, int quantity);

    void updateProductWhenProductNotFound(Optional<Products> product);

    RefundProducts getRefundProductEntity(Refund request);

    Optional<Products> findOne(int id);

    Optional<Products> findByName(String productName);
}
