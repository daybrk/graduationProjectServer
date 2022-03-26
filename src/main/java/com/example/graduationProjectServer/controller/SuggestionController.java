package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.repository.SuggestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SuggestionController {

    @Autowired
    private SuggestionRepo suggestionRepo;

    @PostMapping("/suggestion/create")
    public ResponseEntity createSuggestion(@RequestBody SuggestionStructure suggestion) {
        suggestionRepo.save(suggestion);
        return ResponseEntity.ok("Предложение создано");
    }

    @GetMapping("/suggestion/{emailAuthor}")
    public List<SuggestionStructure> getSuggestionsByEmail(@PathVariable ("emailAuthor") String email) {
        List<SuggestionStructure> suggestionList = new ArrayList<>();

        suggestionList = suggestionRepo.findAllBySuggestionAuthor(email);

        return suggestionList;
    }

    @GetMapping("/suggestion")
    public List<SuggestionStructure> getAllSuggestions() {
        List<SuggestionStructure> suggestionList = new ArrayList<>();

        suggestionList = suggestionRepo.findAll();

        return suggestionList;
    }
}


