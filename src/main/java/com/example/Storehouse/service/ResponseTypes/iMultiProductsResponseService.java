package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.response.MultiProductsResponse;

public interface iMultiProductsResponseService {
    MultiProductsResponse getMultiProductResponse(MultiProductRequest multiProductRequest);
}
