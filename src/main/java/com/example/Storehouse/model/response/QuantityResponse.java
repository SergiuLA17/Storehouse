package com.example.Storehouse.model.response;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class QuantityResponse extends Response {
    private String name;
    private int quantity;


    public QuantityResponse setIdRequest(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public QuantityResponse setName(String name) {
        this.name = name;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Response{" +
                "idRequest=" + uuid +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
