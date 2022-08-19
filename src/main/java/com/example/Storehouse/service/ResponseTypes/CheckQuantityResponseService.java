package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;
import com.example.Storehouse.service.StorehouseService;
import com.example.Storehouse.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckQuantityResponseService implements iCheckQuantityResponseService {
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private StorehouseService storehouseService;

    public CheckQuantityResponse getResponse(CheckQuantityOfProductRequest request) {
        loggerService.showInfoAboutRequest(request);
        loggerService.requestProcessedSuccessfully();
        return CheckQuantityResponse.builder()
                .requestUUID(request.getRequestUUID())
                .nameOfProduct(request.getNameOfProduct())
                .quantityOfProduct(storehouseService.getQuantityOfProduct(request.getNameOfProduct()))
                .build();
    }
}
