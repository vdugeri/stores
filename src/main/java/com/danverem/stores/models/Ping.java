package com.danverem.stores.models;

import java.util.Objects;

public class Ping {
    private String message;

    public Ping(String message) {
        this.message = message;
    }

    public Ping() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ping)) return false;
        Ping ping = (Ping) o;
        return Objects.equals(getMessage(), ping.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage());
    }

    @Override
    public String toString() {
        return "Ping{" +
            "message='" + message + '\'' +
            '}';
    }
}
