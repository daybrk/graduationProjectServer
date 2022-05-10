package com.example.graduationProjectServer.enity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserAndRoleId implements Serializable {

    @OneToOne
    @JoinColumn(name = "user_email")
    private UserStructure userEmail;
    @Column(name = "role")
    private Roles role;

    public UserAndRoleId(UserStructure userEmail, Roles role) {
        this.userEmail = userEmail;
        this.role = role;
    }

    public UserAndRoleId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAndRoleId that = (UserAndRoleId) o;
        return userEmail.equals(that.userEmail) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, role);
    }
}
