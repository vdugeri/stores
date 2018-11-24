package com.danverem.stores.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ItemDTO implements Serializable {


    private Long ID;
    private String name;
    private Integer quantity;
    @JsonProperty("purchase_price")
    private double purchasePrice;
    @JsonProperty("selling_price")
    private double sellingPrice;
    @JsonProperty("date_in")
    private String dateIn;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", quantity=" + quantity +
            ", purchasePrice=" + purchasePrice +
            ", sellingPrice=" + sellingPrice +
            ", dateIn=" + dateIn +
            '}';
    }
}
