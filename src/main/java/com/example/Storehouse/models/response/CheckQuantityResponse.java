package com.example.Storehouse.models.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CheckQuantityResponse {
    private final UUID requestUUID;
    private final String nameOfProduct;
    private final int quantityOfProduct;
}
