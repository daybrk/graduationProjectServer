package com.example.graduationProjectServer.enity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class UserStructure {

    @Id
    private String email;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String secondName;
    private String lastName;
    private String password;
    private int accessRights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(int accessRights) {
        this.accessRights = accessRights;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
