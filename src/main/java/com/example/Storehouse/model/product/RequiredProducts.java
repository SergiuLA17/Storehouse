package com.example.Storehouse.model.product;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class RequiredProducts {
    private UUID uuid;
    private Optional<ArrayList<ProductRequest>> requiredProducts;

    public Optional<ArrayList<ProductRequest>> getRequiredProducts() {
        return requiredProducts;
    }

    public void setRequiredProducts(Optional<ArrayList<ProductRequest>> requiredProduct) {
        this.requiredProducts = requiredProduct;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "RequiredProducts{" +
                "uuidRequest=" + uuid +
                ", requiredProducts=" + requiredProducts +
                '}';
    }
}
