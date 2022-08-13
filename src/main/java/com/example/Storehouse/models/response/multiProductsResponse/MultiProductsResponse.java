package com.example.Storehouse.models.response.multiProductsResponse;

import com.example.Storehouse.models.product.Product;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class MultiProductsResponse {
    protected UUID uuid;
    private final List<Product> products;

}
