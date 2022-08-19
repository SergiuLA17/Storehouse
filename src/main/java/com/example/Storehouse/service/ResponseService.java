package com.example.Storehouse.service;

import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;
import com.example.Storehouse.models.response.MultiProductsResponse;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.models.response.SingleProductResponse;
import com.example.Storehouse.service.ResponseTypes.CheckQuantityResponseService;
import com.example.Storehouse.service.ResponseTypes.MultiProductsResponseService;
import com.example.Storehouse.service.ResponseTypes.RefundProductResponseService;
import com.example.Storehouse.service.ResponseTypes.SingleProductResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService implements iResponseService {
    @Autowired
    MultiProductsResponseService multiProductsResponse;
    @Autowired
    SingleProductResponseService singleProductResponse;
    @Autowired
    CheckQuantityResponseService checkQuantityResponse;
    @Autowired
    RefundProductResponseService refundProductResponse;


    public RefundResponse getResponse(RefundRequest refundRequest){
        return refundProductResponse.getResponse(refundRequest);
    }

    public CheckQuantityResponse getResponse(CheckQuantityOfProductRequest checkQuantityOfProductRequest){
        return checkQuantityResponse.getResponse(checkQuantityOfProductRequest);
    }


    public MultiProductsResponse getResponse(MultiProductRequest multiProductRequest) {
        return multiProductsResponse.getMultiProductResponse(multiProductRequest);
    }

    public SingleProductResponse getResponse(SingleProductRequest singleProductRequest){
        return singleProductResponse.getSingleProductResponse(singleProductRequest);
    }

}
