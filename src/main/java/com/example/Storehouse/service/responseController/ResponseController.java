package com.example.Storehouse.service.responseController;

import com.example.Storehouse.model.response.MultiProductsResponse;
import com.example.Storehouse.model.response.QuantityResponse;
import com.example.Storehouse.model.response.SingleProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseController implements iResponseCOntroller {

    @Autowired
    private SingleProductResponse responseController;

    @Autowired
    private MultiProductsResponse multiProductsResponse;

    @Autowired
    private QuantityResponse quantityResponse;



    public SingleProductResponse response(){
        return responseController;
    }

    public MultiProductsResponse responseMultiProduct(){
        return multiProductsResponse;
    }

    public QuantityResponse quantityResponse() {
        return quantityResponse;
    }


}
