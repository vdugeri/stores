package com.danverem.stores.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "initials")
    private String initials;


    public User(String username, String password, String firstName, String lastName, String initials) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
    }

    public User() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getID(), user.getID()) &&
            Objects.equals(getUsername(), user.getUsername()) &&
            Objects.equals(getPassword(), user.getPassword()) &&
            Objects.equals(getFirstName(), user.getFirstName()) &&
            Objects.equals(getLastName(), user.getLastName()) &&
            Objects.equals(getInitials(), user.getInitials());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getUsername(), getPassword(), getFirstName(), getLastName(), getInitials());
    }

    @Override
    public String toString() {
        return "User{" +
            "ID=" + ID +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", initials='" + initials + '\'' +
            '}';
    }
}
