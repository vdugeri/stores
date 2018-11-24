package com.danverem.stores.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "date_in")
    private LocalDateTime dateIn;

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

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.getPurchasePrice(), getPurchasePrice()) == 0 &&
            Double.compare(item.getSellingPrice(), getSellingPrice()) == 0 &&
            Objects.equals(getID(), item.getID()) &&
            Objects.equals(getName(), item.getName()) &&
            Objects.equals(getQuantity(), item.getQuantity()) &&
            Objects.equals(getDateIn(), item.getDateIn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getQuantity(), getPurchasePrice(), getSellingPrice(), getDateIn());
    }

    @Override
    public String toString() {
        return "Item{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", quantity=" + quantity +
            ", purchasePrice=" + purchasePrice +
            ", sellingPrice=" + sellingPrice +
            ", dateIn=" + dateIn +
            '}';
    }
}
