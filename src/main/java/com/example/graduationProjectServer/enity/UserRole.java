package com.example.graduationProjectServer.enity;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_email")
    private UserStructure userEmail;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Roles roleId;

    public UserRole(UserStructure userEmail, Roles role) {
        this.userEmail = userEmail;
        this.roleId = role;
    }
    public UserRole() {
    }

    public UserStructure getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(UserStructure userEmail) {
        this.userEmail = userEmail;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles role) {
        this.roleId = role;
    }

    public Long getId() {
        return id;
    }
}
