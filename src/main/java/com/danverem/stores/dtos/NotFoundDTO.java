package com.danverem.stores.dtos;

public class NotFoundDTO {

    private String status;
    private String message;

    public NotFoundDTO(String message) {
        this.message = message;
        this.status = "error";
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
