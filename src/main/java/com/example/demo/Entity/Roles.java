package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String Role;

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", Role='" + Role + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Roles(int id, String role) {
        this.id = id;
        Role = role;
    }

    public Roles() {
    }
}
