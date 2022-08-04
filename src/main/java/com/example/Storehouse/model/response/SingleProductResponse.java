package com.example.Storehouse.model.response;

import com.example.Storehouse.model.product.Product;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
public class SingleProductResponse extends Response {
    private Product productRequest;

    public SingleProductResponse() {
    }


    public SingleProductResponse setRequestId(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public Product getProduct() {
        return productRequest;
    }

    public StorehouseService setProduct(Optional<Product> productRequest, StorehouseService service) {
        this.productRequest = productRequest.get();
        return service;
    }

    @Override
    public String toString() {
        return "{" +
                "requestId=" + uuid +
                ", productRequest=" + productRequest +
                '}';
    }
}

