package com.example.graduationProjectServer.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserAndRole implements Serializable{

    @EmbeddedId
    private UserAndRoleId userAndRoleId;

    public UserAndRole(UserAndRoleId userAndRoleId) {
        this.userAndRoleId = userAndRoleId;
    }

    public UserAndRole() {
    }

    public UserAndRoleId getUserAndRoleId() {
        return userAndRoleId;
    }

    public void setUserAndRoleId(UserAndRoleId userAndRoleId) {
        this.userAndRoleId = userAndRoleId;
    }
}
