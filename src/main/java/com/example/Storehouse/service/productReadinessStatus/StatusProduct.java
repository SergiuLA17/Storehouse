package com.example.Storehouse.service.productReadinessStatus;

import com.example.Storehouse.service.StorehouseService;
import org.springframework.stereotype.Component;

@Component
public class StatusProduct {
    boolean status;


    public StorehouseService no(StorehouseService service){
       status = false;
        return service;
    }

    public StorehouseService approved(StorehouseService service){
        status = true;
        return service;
    }

    public boolean get() {
        return status;
    }
}
