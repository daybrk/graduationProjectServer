package com.example.graduationProjectServer.repository;

import com.example.graduationProjectServer.enity.Status;
import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.enity.UserStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepo  extends JpaRepository<SuggestionStructure, Long> {
    List<SuggestionStructure> findAllBySuggestionAuthor(UserStructure email);
    List<SuggestionStructure> findAllBySuggestionInspector(UserStructure email);

    int countBySuggestionInspectorAndSuggestionStatusEquals(UserStructure email, Status status);
}
