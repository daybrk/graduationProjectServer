package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.UserStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserStructure, String> {
    UserStructure findByEmail(String email);
}
