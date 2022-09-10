package com.example.Storehouse.models.response;

import com.example.Storehouse.entity.Products;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class MultiProductsResponse {
    private final UUID uuid;
    private final List<Products> products;

}
