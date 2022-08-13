package com.example.Storehouse.models.request;

import com.example.Storehouse.models.product.ProductRequest;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
@Jacksonized
public class MultiProductRequest {
    protected UUID id;
    private Optional<List<ProductRequest>> requiredProducts;

}
