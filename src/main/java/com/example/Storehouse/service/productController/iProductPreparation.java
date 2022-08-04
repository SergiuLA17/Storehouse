package com.example.Storehouse.service.productController;

import com.example.Storehouse.service.StorehouseService;

public interface iProductPreparation {
    StorehouseService start(StorehouseService service, String name, int quantity);
}
