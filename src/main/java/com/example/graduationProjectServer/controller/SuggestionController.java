package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.Status;
import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.enity.UserStructure;
import com.example.graduationProjectServer.repository.SuggestionRepo;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class SuggestionController {

    @Autowired
    private SuggestionRepo suggestionRepo;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/suggestion/create")
    public ResponseEntity createSuggestion(@RequestBody SuggestionStructure suggestion) {

        suggestionRepo.save(suggestion);
        return ResponseEntity.ok("Предложение создано");
    }

    @DeleteMapping("/suggestion/delete/{suggestionId}")
    public ResponseEntity deleteSuggestion(@PathVariable ("suggestionId") Long suggestionId) {

        SuggestionStructure suggestion = suggestionRepo.findById(suggestionId)
                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
        if (suggestion != null) {
            suggestionRepo.delete(suggestion);
            return ResponseEntity.ok("Предложение удалено");
        } else {
            return ResponseEntity.badRequest().body("Предложение не найдено");
        }
    }

    @PutMapping("/suggestion/confirm/{suggestionId}")
    public ResponseEntity confirmSuggestion(@PathVariable ("suggestionId") Long suggestionId) {

        SuggestionStructure suggestion = suggestionRepo.findById(suggestionId)
                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
        if (suggestion != null) {
            suggestion.setSuggestionStatus(Status.Approved);
            suggestionRepo.save(suggestion);
            return ResponseEntity.ok("Предложение удалено");
        } else {
            return ResponseEntity.badRequest().body("Предложение не найдено");
        }
    }

    @GetMapping("/suggestion/{emailAuthor}")
    public List<SuggestionStructure> getSuggestionsByEmail(@PathVariable ("emailAuthor") String email) {
        UserStructure user = userRepo.findByEmail(email);

        return suggestionRepo.findAllBySuggestionAuthor(user);
    }

    @GetMapping("/suggestion")
    public List<SuggestionStructure> getAllSuggestions() {

        return suggestionRepo.findAll();
    }
}


