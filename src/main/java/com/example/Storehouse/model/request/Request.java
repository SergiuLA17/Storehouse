package com.example.Storehouse.model.request;

import java.util.UUID;

public class Request {
    protected UUID id;

    public UUID getUuid() {
        return id;
    }

    public void setUuid(UUID id) {
        this.id = id;
    }

}
