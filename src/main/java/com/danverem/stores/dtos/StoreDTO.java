package com.danverem.stores.dtos;

import java.io.Serializable;

public class StoreDTO implements Serializable {

    private Long ID;
    private String name;
    private String address;
    private String accountCode;

    public StoreDTO(String name, String address, String accountCode) {
        this.name = name;
        this.address = address;
        this.accountCode = accountCode;
    }

    public StoreDTO(Long ID, String name, String address, String accountCode) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.accountCode = accountCode;
    }

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
    public String toString() {
        return "StoreDTO{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", accountCode='" + accountCode + '\'' +
            '}';
    }
}
