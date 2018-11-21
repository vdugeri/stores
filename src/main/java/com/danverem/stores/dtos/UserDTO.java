package com.danverem.stores.dtos;

public class UserDTO {
    private String username;
    private String password;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String intials;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIntials() {
        return intials;
    }

    public void setIntials(String intials) {
        this.intials = intials;
    }
}
