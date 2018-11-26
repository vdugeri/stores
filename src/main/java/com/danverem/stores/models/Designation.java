package com.danverem.stores.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "designations")
@NamedQueries({
    @NamedQuery(name = Designation.FIND_BY_CODE, query = "SELECT d FROM  Designation d WHERE d.code = :code")
})
public class Designation {

    public final static String FIND_BY_CODE = "Designation.findByCode";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Designation)) return false;
        Designation that = (Designation) o;
        return Objects.equals(getID(), that.getID()) &&
            Objects.equals(getName(), that.getName()) &&
            Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName(), getCode());
    }

    @Override
    public String toString() {
        return "Designation{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            '}';
    }
}
