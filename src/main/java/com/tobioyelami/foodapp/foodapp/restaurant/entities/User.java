package com.tobioyelami.foodapp.foodapp.restaurant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by tobioyelami on 02/12/2018
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private char[] password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }


    public char[] getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
