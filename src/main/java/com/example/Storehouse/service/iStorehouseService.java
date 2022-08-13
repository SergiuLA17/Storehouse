package com.example.Storehouse.service;

import com.example.Storehouse.models.response.singleProductResponse.SingleProductResponse;

import java.util.UUID;

public interface iStorehouseService {
    SingleProductResponse processesSingleProductRequest(String name, int quantity, UUID uuid);
//    MultiProductsResponse buildMultiProductsResponse(RequestMultiProducts request);
//    QuantityResponse buildingQuantityResponse(UUID uuid, String name);
}
