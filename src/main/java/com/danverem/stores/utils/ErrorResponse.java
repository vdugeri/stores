package com.danverem.stores.utils;

public class ErrorResponse {

    private String status;
    private String message;

    public ErrorResponse(String message) {
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
