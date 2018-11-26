package com.danverem.stores.dtos;

import java.io.Serializable;

public class DesignationDTO implements Serializable {

    private String code;
    private String name;
    private Long ID;


    public DesignationDTO() {
    }

    public DesignationDTO(String code, String name, Long ID) {
        this.code = code;
        this.name = name;
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "DesignationDTO{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", ID=" + ID +
            '}';
    }
}
