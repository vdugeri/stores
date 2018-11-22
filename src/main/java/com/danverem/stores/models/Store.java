package com.danverem.stores.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "stores")
public class Store implements Serializable {

    @Id
    @Column(name = "id")
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "account_code")
    private String accountCode;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return Objects.equals(getID(), store.getID()) &&
            Objects.equals(getName(), store.getName()) &&
            Objects.equals(getAddress(), store.getAddress()) &&
            Objects.equals(getAccountCode(), store.getAccountCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getAddress(), getAccountCode());
    }

    @Override
    public String toString() {
        return "Store{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", accountCode='" + accountCode + '\'' +
            '}';
    }
}
