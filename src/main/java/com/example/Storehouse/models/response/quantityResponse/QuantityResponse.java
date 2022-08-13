package com.example.Storehouse.models.response.quantityResponse;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Builder
@Data
@Component
@NoArgsConstructor
public class QuantityResponse {
    protected UUID uuid;
    private String name;
    private int quantity;

    public QuantityResponse(UUID uuid, String name, int quantity) {
        this.uuid = uuid;
        this.name = name;
        this.quantity = quantity;
    }
}
