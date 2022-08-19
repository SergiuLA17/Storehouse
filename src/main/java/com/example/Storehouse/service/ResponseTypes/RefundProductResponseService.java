package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.service.StorehouseService;
import com.example.Storehouse.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundProductResponseService implements iRefundProductResponseService {
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private StorehouseService storehouseService;

    public RefundResponse getResponse(RefundRequest refundRequest) {
        loggerService.showInfoAboutRequest(refundRequest);
        storehouseService.saveRefundProduct(refundRequest.getRefundProduct());
        loggerService.requestProcessedSuccessfully();
        return RefundResponse.builder()
                .requestUUID(refundRequest.getRequestUUID())
                .message("Request was successfully processed")
                .build();
    }
}
