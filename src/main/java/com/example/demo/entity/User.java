package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // REQUIRED
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {   // REQUIRED
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { // REQUIRED
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { // REQUIRED
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) { // REQUIRED
        this.role = role;
    }
}
