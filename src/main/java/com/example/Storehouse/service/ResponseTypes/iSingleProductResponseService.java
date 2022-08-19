package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.SingleProductResponse;

public interface iSingleProductResponseService {
    SingleProductResponse getSingleProductResponse(SingleProductRequest singleProductRequest);
}
