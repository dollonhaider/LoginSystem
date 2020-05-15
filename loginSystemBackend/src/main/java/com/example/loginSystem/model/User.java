package com.example.loginSystem.model;
import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

public class User{
    @Id
    private ObjectId id;
    private String email;
    private String password;

    public User() {
    }

    public User(ObjectId id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
}
