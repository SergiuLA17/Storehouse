package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.SingleProductResponse;
import com.example.Storehouse.service.StorehouseService;
import com.example.Storehouse.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingleProductResponseService implements iSingleProductResponseService{
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private StorehouseService storehouseService;

    public SingleProductResponse getSingleProductResponse(SingleProductRequest singleProductRequest) {
        proceedProduct(singleProductRequest);
        loggerService.requestProcessedSuccessfully();
        return SingleProductResponse.builder()
                .nameOfProduct(buildProductForResponse(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName()).get())
                .requestUUID(singleProductRequest.getRequestUUID())
                .build();
    }

    private void proceedProduct(SingleProductRequest singleProductRequest) {
        loggerService.showInfoAboutRequest(singleProductRequest);

        if (storehouseService.checkIfThereIsEnoughProductQuantity(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName())) {
            storehouseService.updateDataBase(singleProductRequest.getProductName(),singleProductRequest.getProductQuantity());
        } else {
            storehouseService.updateQuantityProduct(singleProductRequest.getProductName());
            storehouseService.updateDataBase(singleProductRequest.getProductName(),singleProductRequest.getProductQuantity());
        }
    }

    private Optional<Product> buildProductForResponse(int quantity, String name) {
        return storehouseService.findByName(name).map(products ->
                Product.builder()
                        .idProduct(products.getIdProduct())
                        .name(products.getName())
                        .quantity(quantity)
                        .dateOfManufacture(products.getDateOfManufacture())
                        .daysToExpire(products.getDaysToExpire())
                        .build());
    }
}
