package com.example.Storehouse.service.productController;

import com.example.Storehouse.service.StorehouseService;
import org.springframework.stereotype.Component;

@Component
public class ProductPreparation {

    public StorehouseService start(StorehouseService service, String name, int quantity) {
        while (!service.statusApproved().get()) {
            if (service.checkQuantityProduct(service.productController().getTemptProductObj(), quantity)) {
                service.updateProductWhenPurchased(service.productController().getTemptProductObj(), quantity)
                        .productController().setRequiredProduct(service.productController().getTemptProductObj(), quantity,service)
                        .print().info("Request has been granted!", service)
                        .statusApproved().approved(service);

            } else {
                service.print().info("Insufficient amount of product: " + name + ", quantity: " + quantity, service)
                        .updateProductWhenProductNotFound(service.productController().getTemptProductObj());
            }
        }
        return service;
    }
}
