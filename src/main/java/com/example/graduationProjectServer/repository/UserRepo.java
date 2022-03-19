package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.UserEmployee;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<UserEmployee, String> {
}
