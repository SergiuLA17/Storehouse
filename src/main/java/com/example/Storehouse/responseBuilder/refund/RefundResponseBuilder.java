package com.example.Storehouse.responseBuilder.refund;

import com.example.Storehouse.logger.Print;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundResponseBuilder implements iRefundResponseBuilder {
    @Autowired
    private Print print;
    @Autowired
    private StorehouseService service;
    private RefundRequest request;
    private RefundResponse response;

    public void dataProcessing(RefundRequest superMarketRequest) {
        request = RefundRequest.builder()
                .product(superMarketRequest.getProduct())
                .id(superMarketRequest.getId())
                .build();

        print.info("New request. Refund product. Id request: " + request.getId() + ", product: " + request.getProduct());
    }

    public void build() {
        service.saveRefundProduct(request.getProduct());
        response = RefundResponse.builder()
                .uuid(request.getId())
                .message("Request was successfully processed")
                .build();

    }

    public void buildCompletedSuccessfully() {
        print.info("Request was successfully processed");
    }

    public RefundResponse getResponse() {
        return response;
    }

}
