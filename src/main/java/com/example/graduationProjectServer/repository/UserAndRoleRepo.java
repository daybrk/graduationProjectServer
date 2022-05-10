package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.Roles;
import com.example.graduationProjectServer.enity.UserAndRole;
import com.example.graduationProjectServer.enity.UserAndRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserAndRoleRepo extends CrudRepository<UserAndRole, UserAndRoleId> {

}
