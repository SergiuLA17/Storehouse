package com.example.Storehouse.models.response.singleProductResponse;

import com.example.Storehouse.models.product.Product;
import lombok.Builder;
import lombok.Data;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class SingleProductResponse {
    private UUID uuid;
    private Optional <Product> product;

}
