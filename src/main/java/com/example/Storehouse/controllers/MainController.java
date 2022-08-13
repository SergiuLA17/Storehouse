package com.example.Storehouse.controllers;

import com.example.Storehouse.responseBuilder.multiproduct.MultiProductResponseBuilder;
import com.example.Storehouse.responseBuilder.quantity.QuantityOfProductResponseBuilder;
import com.example.Storehouse.responseBuilder.refund.RefundResponseBuilder;
import com.example.Storehouse.responseBuilder.singleProduct.SingleProductResponseBuilding;
import com.example.Storehouse.models.request.QuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller

@RestController
@Api(description = "Storehouse")
public class MainController {
    @Autowired
    SingleProductResponseBuilding singleProductResponse;
    @Autowired
    MultiProductResponseBuilder multiProductResponse;
    @Autowired
    QuantityOfProductResponseBuilder quantityOfProductResponse;
    @Autowired
    RefundResponseBuilder refundResponse;


    @PostMapping("/getProduct")
    @ResponseBody
    public ResponseEntity<?> getProduct(@RequestBody(required = false) SingleProductRequest request) {
        singleProductResponse.dataPreparation(request);

        singleProductResponse.build();

        singleProductResponse.buildCompletedSuccessfully();

        return ResponseEntity.ok(singleProductResponse.getResponse());
    }

    @PostMapping("/getMultipleProducts")
    @ResponseBody
    public ResponseEntity<?> getMultipleProducts(@RequestBody(required = false) MultiProductRequest request) {
        multiProductResponse.dataPreparation(request);

        multiProductResponse.build();

        multiProductResponse.buildCompletedSuccessfully();

       return ResponseEntity.ok(multiProductResponse.getResponse());
    }

    @PostMapping("/getQuantity")
    @ResponseBody
    public ResponseEntity<?> getQuantity(@RequestBody(required = false) QuantityOfProductRequest request) {
        quantityOfProductResponse.dataPreparing(request);

        quantityOfProductResponse.build();

        quantityOfProductResponse.buildCompletedSuccessfully();

        return ResponseEntity.ok(quantityOfProductResponse.getResponse());
    }

    @PostMapping("/returnProduct")
    @ResponseBody
    public ResponseEntity<?> getReturnedProduct(@RequestBody(required = false) RefundRequest request) {
        refundResponse.dataProcessing(request);

        refundResponse.build();

        refundResponse.buildCompletedSuccessfully();

        return ResponseEntity.ok(refundResponse.getResponse());
    }
}

