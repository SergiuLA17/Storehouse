package com.example.Storehouse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class RefundProducts  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;
    public RefundProducts(int idProduct, String nameOfProduct, int quantity, LocalDateTime dateOfManufacture, int daysToExpire) {
        this.idProduct = idProduct;
        this.name = nameOfProduct;
        this.quantity = quantity;
        this.dateOfManufacture = dateOfManufacture;
        this.daysToExpire = daysToExpire;
    }

    public RefundProducts() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameOfProduct() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateOfManufacture() {
        return dateOfManufacture;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.name = nameOfProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDateOfManufacture(LocalDateTime dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String productNoFound() {
        return "Sorry, product wasn't found!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + "\n" +
                        "Quantity = " + quantity +
                        " Date of manufacture = "
                        + dateOfManufacture.getYear() + "-"
                        + dateOfManufacture.getMonth() + "-"
                        + dateOfManufacture.getDayOfMonth() + " Time: "
                        + dateOfManufacture.getHour() + ":" +
                        +dateOfManufacture.getMinute() +
                        " Days to expire = " + daysToExpire;
    }
}
