package com.example.Storehouse.service.print;

import com.example.Storehouse.service.StorehouseService;

public interface iPrint {
    StorehouseService info(String text,StorehouseService service);
    StorehouseService error(String text,StorehouseService service);
    StorehouseService warn(String text,StorehouseService service);
}
