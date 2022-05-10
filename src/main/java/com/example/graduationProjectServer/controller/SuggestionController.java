package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.SuggestionFromClient;
import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.enity.UserStructure;
import com.example.graduationProjectServer.repository.SuggestionRepo;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SuggestionController {

    @Autowired
    private SuggestionRepo suggestionRepo;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/suggestion/create")
    public ResponseEntity createSuggestion(@RequestBody SuggestionFromClient suggestion) {

        UserStructure user = userRepo.findByEmail(suggestion.getSuggestionAuthor());

        SuggestionStructure suggestionStructure =
                new SuggestionStructure(
                        suggestion.getSuggestion(), suggestion.getSuggestionTheme(), suggestion.getSuggestionDate(),
                        suggestion.getSuggestionStatus(), user);

        suggestionRepo.save(suggestionStructure);
        return ResponseEntity.ok("Предложение создано");
    }

    @GetMapping("/suggestion/{emailAuthor}")
    public List<SuggestionStructure> getSuggestionsByEmail(@PathVariable ("emailAuthor") String email) {
        List<SuggestionStructure> suggestionList = new ArrayList<>();
        UserStructure user = userRepo.findByEmail(email);
        suggestionList = suggestionRepo.findAllBySuggestionAuthor(user);

        return suggestionList;
    }

    @GetMapping("/suggestion")
    public List<SuggestionStructure> getAllSuggestions() {
        List<SuggestionStructure> suggestionList = new ArrayList<>();

        suggestionList = suggestionRepo.findAll();

        return suggestionList;
    }
}


