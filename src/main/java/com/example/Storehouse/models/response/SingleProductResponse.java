package com.example.Storehouse.models.response;

import com.example.Storehouse.models.product.Product;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SingleProductResponse {
    private final UUID requestUUID;
    private final Product nameOfProduct;

}
