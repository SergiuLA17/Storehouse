package com.example.Storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
@SuppressWarnings("SpringJavaAutowiringInspection")
public class StorehouseApplication {

    public static void main(String[] args) {

        SpringApplication.run(StorehouseApplication.class, args);

    }
}