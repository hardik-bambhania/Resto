package com.be.msu.resto.model;

/**
 * Created by TANKBHAI on 17-11-2016.
 */
public class RegistrationCredentials {
    int id;
    String username;
    String password;

    public RegistrationCredentials() {
    }

    public RegistrationCredentials(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public RegistrationCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
