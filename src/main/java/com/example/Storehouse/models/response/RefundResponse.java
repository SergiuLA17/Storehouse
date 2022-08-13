package com.example.Storehouse.models.response;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder

public class RefundResponse {
    private UUID uuid;
    private String message;

}

