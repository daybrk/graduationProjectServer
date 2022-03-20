package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo  extends JpaRepository<UserEmployee, String> {
    UserEmployee findByEmail(String email);
}
