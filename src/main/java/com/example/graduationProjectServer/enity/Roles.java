package com.example.graduationProjectServer.enity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

    @Id
    private Long id;
    private String Role;



    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
