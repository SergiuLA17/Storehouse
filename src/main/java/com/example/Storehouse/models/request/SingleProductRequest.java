package com.example.Storehouse.models.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Builder
@Data
@Jacksonized
public class SingleProductRequest {
    String name;
    int quantity;
    UUID uuid;

}
