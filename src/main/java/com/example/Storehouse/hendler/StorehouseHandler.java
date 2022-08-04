package com.example.Storehouse.hendler;

import com.example.Storehouse.model.product.ProductRequest;
import com.example.Storehouse.model.product.RequiredProducts;
import com.example.Storehouse.model.request.Refund;
import com.example.Storehouse.repository.RefundProductRepository;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class StorehouseHandler {
    @Autowired
    private StorehouseService service;
    @Autowired
    private RefundProductRepository productRepository;

    public ResponseEntity response(String name, int quantity, UUID id) {
        service.productController()
                .setTemptProductObject(service.findByName(name), service)
                .print().info("Request to purchase " + quantity + " kg of " + name, service)
                .statusApproved().no(service);

        if (!service.productController().getTemptProductObj().isPresent()) {
            service.print().info("Product not found or wrong product name " + name, service);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or wrong product name " + name);
        } else {
            service.preparationProductForResponse().start(service, name, quantity)
                    .responseController().response()
                                         .setRequestId(id)
                                         .setProduct(service.productController().getRequiredProduct(), service)
                    .print().info("Response has been send to market. Response: " + service.responseController().response().toString(), service);
            return ResponseEntity.ok(service.responseController().response());
        }
    }

    public ResponseEntity response(RequiredProducts request) {
        service.print().info("New request :" + request.toString(),service);
        for (ProductRequest product : request.getRequiredProducts().get()) {
            service.productController().setTemptProductObject(service.findByName(product.getName()), service)
                    .statusApproved().no(service);
            if (service.productController().getTemptProductObj().isPresent()) {
                service.print().info("Request to purchase " + product.getQuantity() + " kg of " + product.getName(), service)
                        .preparationProductForResponse().start(service, product.getName(), product.getQuantity())
                        .responseController().responseMultiProduct()
                                             .setId(request.getUuid())
                                             .setProducts(service.productController().getRequiredProduct().get(), service);
            } else
                service.print().info("Product not found or wrong product name " + product.getName(), service);
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or wrong product name " + product.getName());
        }

        if (service.responseController().responseMultiProduct().getProducts().size() == 0) {
            service.print().info("Products not found or wrong product names", service);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found or wrong product names");
        } else {
            service.print().info("Response has been send to market. Response: " + service.responseController().responseMultiProduct().toString(), service);
            return ResponseEntity.ok(service.responseController().responseMultiProduct());
        }
    }

    public ResponseEntity response(String name, UUID id){
        service.print().info("Request to check quantity of product. id request: " + id + " product name " + name, service)
                .productController().setTemptProductObject(service.findByName(name), service);
        if (!service.productController().getTemptProductObj().isPresent()) {
            service.print().info("Product not found or wrong product name " + name, service);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or wrong product name " + name);

        } else {
            service.responseController().quantityResponse()
                                        .setIdRequest(id)
                                        .setName(service.productController().getTemptProductObj().get().getName());

            service.print().info("Response has been send to market. Response: " + service.responseController().quantityResponse().toString(), service);

            return ResponseEntity.ok(service.responseController().quantityResponse());
        }
    }

    public ResponseEntity response(Refund request){
        service.print().info("We have a return product:" + request, service);
        service.saveRefundProduct(service.getRefundProductEntity(request));
        return ResponseEntity.ok("Your return request has been received. Your request:  " + request);
    }
}
