package com.danverem.stores.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "stores")
@NamedQueries({
    @NamedQuery(name = Store.FIND_BY_NAME, query = "SELECT s FROM Store s WHERE s.name = :name"),
    @NamedQuery(name = Store.FIND_BY_CODE, query = "SELECT s FROM Store s WHERE s.accountCode = :code")
})
public class Store implements Serializable {

    public static final String FIND_BY_NAME = "Store.findByName";
    public static final String FIND_BY_CODE = "Store.findByCode";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "account_code", unique = true)
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
