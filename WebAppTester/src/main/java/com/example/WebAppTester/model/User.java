package com.example.WebAppTester.model;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //primary key

    private String username;
    private String password;
    private String role;

    // username getter & setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {

        this.username = username;
    }

    //-------------------------
    // id getter & setter

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    //-----------------------------
    // password getter & setter

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // -----------------------------
    // role getter & setter

    public String getRole() {

        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }
}
