package com.example.Storehouse.service.print;

import com.example.Storehouse.controllers.MainController;
import com.example.Storehouse.service.StorehouseService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Print implements iPrint{
    private final Logger logger = LoggerFactory.getLogger(MainController.class);


    @Override
    public StorehouseService info(String text,StorehouseService service) {
        logger.info(text);
        return service;
    }

    @Override
    public StorehouseService error(String text, StorehouseService service) {
        logger.error(text);
        return service;
    }

    @Override
    public StorehouseService warn(String text, StorehouseService service) {
        logger.warn(text);
        return service;
    }

}