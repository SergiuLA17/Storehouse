package com.example.Storehouse.logger;

import com.example.Storehouse.controllers.StorehouseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Print implements iPrint{
    private final Logger logger = LoggerFactory.getLogger(StorehouseController.class);


    @Override
    public void info(String text) {
        logger.info(text);
    }

    @Override
    public void error(String text) {
        logger.error(text);
    }

    @Override
    public void warn(String text) {
        logger.warn(text);
    }

}