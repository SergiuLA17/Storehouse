package com.example.Storehouse.service.responseController;

import com.example.Storehouse.model.response.MultiProductsResponse;
import com.example.Storehouse.model.response.QuantityResponse;
import com.example.Storehouse.model.response.SingleProductResponse;

public interface iResponseCOntroller {
    SingleProductResponse response();

    MultiProductsResponse responseMultiProduct();

    QuantityResponse quantityResponse();
}
