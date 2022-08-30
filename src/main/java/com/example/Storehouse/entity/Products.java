package com.example.Storehouse.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;

    public Products(int idProduct, String name, int quantity, LocalDateTime dateOfManufacture, int daysToExpire) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.dateOfManufacture = dateOfManufacture;
        this.daysToExpire = daysToExpire;
    }

    public Products() {
    }
}

