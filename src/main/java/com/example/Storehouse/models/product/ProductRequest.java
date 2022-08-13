package com.example.Storehouse.models.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {

    private  String name;
    private  int quantity;

}

