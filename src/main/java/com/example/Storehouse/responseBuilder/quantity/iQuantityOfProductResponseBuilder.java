package com.example.Storehouse.responseBuilder.quantity;

import com.example.Storehouse.responseBuilder.iResponseBuilder;
import com.example.Storehouse.models.request.QuantityOfProductRequest;
import com.example.Storehouse.models.response.quantityResponse.QuantityResponse;

public interface iQuantityOfProductResponseBuilder extends iResponseBuilder {
     void dataPreparing(QuantityOfProductRequest supermarketRequest);
     QuantityResponse getResponse();
}
