package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
