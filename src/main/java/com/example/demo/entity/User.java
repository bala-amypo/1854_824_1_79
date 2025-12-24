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

    /* ===== GETTERS / SETTERS (TEST REQUIRED) ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // REQUIRED BY TESTS
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {   // REQUIRED BY TESTS
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
