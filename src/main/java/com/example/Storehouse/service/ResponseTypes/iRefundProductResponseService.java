package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.response.RefundResponse;

public interface iRefundProductResponseService {
    RefundResponse getResponse(RefundRequest refundRequest);
}
