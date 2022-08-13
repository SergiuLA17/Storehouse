package com.example.Storehouse.responseBuilder.quantity;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.exceptions.ProductNotFoundException;
import com.example.Storehouse.logger.Print;
import com.example.Storehouse.models.request.QuantityOfProductRequest;
import com.example.Storehouse.models.response.quantityResponse.QuantityResponse;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuantityOfProductResponseBuilder implements iQuantityOfProductResponseBuilder {
    @Autowired
    private Print print;
    @Autowired
    private StorehouseService service;
    private QuantityResponse response;
    private QuantityOfProductRequest request;

    public void dataPreparing(QuantityOfProductRequest supermarketRequest) {
        request = QuantityOfProductRequest.builder()
                .name(supermarketRequest.getName())
                .uuid(supermarketRequest.getUuid())
                .build();
        print.info("New request. Check quantity of product. Request id: " + request.getUuid() + ", product name: " + request.getName());
    }

    public void build() {
        Optional<Products> foundedProduct = service.findByName(request.getName());
        if (foundedProduct.isPresent()) {
            response = QuantityResponse.builder()
                    .uuid(request.getUuid())
                    .name(request.getName())
                    .quantity(foundedProduct.get().getQuantity())
                    .build();
        } else
            throw new ProductNotFoundException("No found product or wrong name, Request product name: " + request.getName());

    }

    public void buildCompletedSuccessfully() {
        print.info("Request was successfully processed");
    }

    public QuantityResponse getResponse() {
        return response;
    }
}
