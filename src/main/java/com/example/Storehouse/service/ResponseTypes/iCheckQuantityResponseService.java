package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;

public interface iCheckQuantityResponseService {
    CheckQuantityResponse getResponse(CheckQuantityOfProductRequest request);
}
