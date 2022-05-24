package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.Roles;
import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.enity.UserRole;
import com.example.graduationProjectServer.enity.UserStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleByUserEmail(UserStructure user);
    List<UserRole> findAllByRoleIdEquals(Roles role);

}
