package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.UserStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<UserStructure, String> {
    UserStructure findByEmail(String email);
}
