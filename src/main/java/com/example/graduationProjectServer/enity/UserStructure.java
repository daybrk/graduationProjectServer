package com.example.graduationProjectServer.enity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class UserStructure {

    @Id
    @Column(name = "user_email")
    private String email;
    private String password;
    private String secondName;
    private String name;
    private String lastName;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStructure that = (UserStructure) o;
        return email.equals(that.email) && password.equals(that.password) && secondName.equals(that.secondName) && name.equals(that.name) && lastName.equals(that.lastName) && token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, secondName, name, lastName, token);
    }
}
