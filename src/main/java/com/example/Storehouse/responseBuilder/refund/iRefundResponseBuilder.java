package com.example.Storehouse.responseBuilder.refund;
import com.example.Storehouse.responseBuilder.iResponseBuilder;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.response.RefundResponse;

public interface iRefundResponseBuilder extends iResponseBuilder {
    void dataProcessing(RefundRequest superMarketRequest);
    void buildCompletedSuccessfully();
    RefundResponse getResponse();
}
