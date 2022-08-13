package com.example.Storehouse.responseBuilder.multiproduct;

import com.example.Storehouse.responseBuilder.iResponseBuilder;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.response.multiProductsResponse.MultiProductsResponse;

import java.util.Optional;

public interface iMultiProductResponseBuilder extends iResponseBuilder {
    void dataPreparation(MultiProductRequest superMarketRequest);

    void requestToFoundProduct(String name);

    boolean checkIfThereIsEnoughProductQuantity(int quantity);

    Optional<Product> buildProductForResponse(int quantity);

    void requestToUpdateProductQuantity(int quantity);

    void requestToUpdateProduct(int quantity);

    void addDataToResponse();

    MultiProductsResponse getResponse();


}
