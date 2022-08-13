package com.example.Storehouse.responseBuilder.singleProduct;

import com.example.Storehouse.responseBuilder.iResponseBuilder;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.singleProductResponse.SingleProductResponse;

import java.util.Optional;

public interface iSingleProductResponseBuilder extends iResponseBuilder {
    void dataPreparation(SingleProductRequest SuperMarketRequest);
    void requestToFoundProduct();
    boolean checkIfThereIsEnoughProductQuantity();
    void addDataToResponse();
    Optional<Product> buildProductForResponse();
    void requestToUpdateProductQuantity();
    void requestToUpdateProduct();
    SingleProductResponse getResponse();
}
