package com.ky.models;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String photo;
    private String createdAt;

    public User() {
    }

    public User(String username, String email, String password, String photo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public User(int id, String username, String email, String password, String photo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
