package com.example.Storehouse.models.request;

import com.example.Storehouse.entity.RefundProducts;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class RefundRequest
{
    private UUID requestUUID;
    private RefundProducts refundProduct;

}
