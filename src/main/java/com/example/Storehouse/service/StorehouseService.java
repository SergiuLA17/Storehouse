package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.model.request.Refund;
import com.example.Storehouse.repository.ProductRepository;
import com.example.Storehouse.repository.RefundProductRepository;
import com.example.Storehouse.service.print.Print;
import com.example.Storehouse.service.productController.ProductController;
import com.example.Storehouse.service.productController.ProductPreparation;
import com.example.Storehouse.service.productReadinessStatus.StatusProduct;
import com.example.Storehouse.service.responseController.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class StorehouseService implements iStorehouseService {
    @Autowired
    private ProductPreparation productPreparation;
    @Autowired
    private ProductController controller;
    @Autowired
    private StatusProduct status;
    @Autowired
    private ResponseController response;
    @Autowired
    private Print logger;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RefundProductRepository refundProductRepository;


    public ProductController productController() {
        return controller;
    }

    public StatusProduct statusApproved() {
        return status;
    }

    public Print print() {
        return logger;
    }

    public ProductPreparation preparationProductForResponse() {
        return productPreparation;
    }

    public ResponseController responseController() {
        return response;
    }


    public StorehouseService updateProductWhenPurchased(Optional<Products> product, int quantity) {
        Optional<Products> products = findOne(product.get().getIdProduct());
        products.ifPresent(value -> value.setQuantity(value.getQuantity() - quantity));
        products.ifPresent(value -> productRepository.save(value));
        return this;
    }


    public boolean checkQuantityProduct(Optional<Products> products, int quantity) {
        return products.filter(value -> value.getQuantity() > quantity).isPresent();
    }

    public void updateProductWhenProductNotFound(Optional<Products> product) {
        if (product.isPresent()) {
            Optional<Products> products = findOne(product.get().getIdProduct());
            products.ifPresent(value -> value.setQuantity(200 + (int) (Math.random() * 500)));
            products.ifPresent(value -> logger.info("Product <" + value.getNameOfProduct() + "> is over, loading more. Now in store is " + value.getQuantity() + " kg", this));
            products.ifPresent(value -> productRepository.save(value));
        }
    }

    public RefundProducts getRefundProductEntity(Refund request) {
        RefundProducts refundProduct = new RefundProducts();
        refundProduct.setNameOfProduct(request.getProduct().getName());
        refundProduct.setQuantity(request.getProduct().getQuantity());
        refundProduct.setDateOfManufacture(request.getProduct().getDateOfManufacture());
        refundProduct.setDaysToExpire(request.getProduct().getDaysToExpire());
        return refundProduct;
    }


    public Optional<Products> findOne(int id) {
        return productRepository.findById(id);
    }

    public Optional<Products> findByName(String productName) {
        return productRepository.findByName(productName);
    }

    public void saveRefundProduct(RefundProducts product) {
        refundProductRepository.save(product);
    }


}
