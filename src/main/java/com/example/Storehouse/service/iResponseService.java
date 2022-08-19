package com.example.Storehouse.service;

import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;
import com.example.Storehouse.models.response.MultiProductsResponse;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.models.response.SingleProductResponse;

import java.util.Optional;

public interface iResponseService {

    SingleProductResponse getResponse(SingleProductRequest singleProductRequest);
    RefundResponse getResponse(RefundRequest refundRequest);
    CheckQuantityResponse getResponse(CheckQuantityOfProductRequest request);
    MultiProductsResponse getResponse(MultiProductRequest multiProductRequest);


}
