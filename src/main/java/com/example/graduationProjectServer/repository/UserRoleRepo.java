package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.UserRole;
import com.example.graduationProjectServer.enity.UserStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    UserRole findUserRoleByUserEmail(UserStructure user);
}
