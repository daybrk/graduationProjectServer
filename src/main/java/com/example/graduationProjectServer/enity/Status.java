package com.example.graduationProjectServer.enity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
    @Id
    private Long id;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
