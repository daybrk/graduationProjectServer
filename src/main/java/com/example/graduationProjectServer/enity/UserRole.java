package com.example.graduationProjectServer.enity;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private UserStructure userEmail;
    @Column(name = "role")
    private Roles role;

    public UserRole(UserStructure userEmail, Roles role) {
        this.userEmail = userEmail;
        this.role = role;
    }
    public UserRole() {
    }

    public UserStructure getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(UserStructure userEmail) {
        this.userEmail = userEmail;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }
}
