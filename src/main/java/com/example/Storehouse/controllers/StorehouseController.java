package com.example.Storehouse.controllers;

import com.example.Storehouse.exception.exceptions.ServerErrorException;
import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.service.ResponseService;
import com.example.Storehouse.service.logger.LoggerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@Api(description = "Storehouse")
public class StorehouseController {
    @Autowired
    ResponseService responseService;

    @Autowired
    LoggerService loggerService;
    @PostMapping("/getProduct")
    @ResponseBody
    public ResponseEntity<?> getProduct(@RequestBody(required = false) SingleProductRequest request) {
            return ResponseEntity.ok(responseService.getResponse(request));

    }

   @PostMapping("/getMultipleProducts")
    @ResponseBody
    public ResponseEntity<?> getMultipleProducts(@RequestBody(required = false) MultiProductRequest request) {
           return ResponseEntity.ok(responseService.getResponse(request));

    }

    @PostMapping("/getQuantity")
    @ResponseBody
    public ResponseEntity<?> getQuantity(@RequestBody(required = false) CheckQuantityOfProductRequest request) {
            return ResponseEntity.ok(responseService.getResponse(request));
    }

    @PostMapping("/returnProduct")
    @ResponseBody
    public ResponseEntity<?> getReturnedProduct(@RequestBody(required = false) RefundRequest request) {
            return ResponseEntity.ok(responseService.getResponse(request));

    }
}

