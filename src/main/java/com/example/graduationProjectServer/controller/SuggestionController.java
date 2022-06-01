package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.Status;
import com.example.graduationProjectServer.enity.SuggestionStructure;
import com.example.graduationProjectServer.enity.UserRole;
import com.example.graduationProjectServer.enity.UserStructure;
import com.example.graduationProjectServer.repository.*;
import com.example.graduationProjectServer.service.PushNotificationService;
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
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private RolesRepo rolesRepo;

    private int count = 0;

    @PostMapping("/suggestion/create")
    public ResponseEntity createSuggestion(@RequestBody SuggestionStructure suggestion) {

        List<UserRole> usersWithRoles = userRoleRepo.findAllByRoleIdEquals(rolesRepo.getById(0L));
        List<UserStructure> moderators = new ArrayList<>();
        for (UserRole sortedSuggestion : usersWithRoles) {
            moderators.add(sortedSuggestion.getUserEmail());
        }

        if (count >= moderators.size() - 1) {
            count = 0;
        } else {
            count++;
        }

        suggestion.setSuggestionInspector(moderators.get(count));
        suggestionRepo.save(suggestion);

        return ResponseEntity.ok("Предложение создано");
    }

    @DeleteMapping("/suggestion/delete/{suggestionId}/{suggestionInspector}")
    public ResponseEntity deleteSuggestion(@PathVariable ("suggestionId") Long suggestionId,
                                           @PathVariable ("suggestionInspector") String suggestionInspector) {

        SuggestionStructure suggestion = suggestionRepo.findById(suggestionId)
                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
        if (suggestion != null) {
            suggestion.setSuggestionStatus(statusRepo.getById(2L));
            suggestion.setSuggestionInspector(userRepo.findByEmail(suggestionInspector));
            suggestionRepo.save(suggestion);
            return ResponseEntity.ok("Предложение отклонено");
        } else {
            return ResponseEntity.badRequest().body("Предложение не найдено");
        }
    }

    @PutMapping("/suggestion/confirm/{suggestionId}/{suggestionInspector}")
    public ResponseEntity confirmSuggestion(@PathVariable ("suggestionId") Long suggestionId,
                                            @PathVariable ("suggestionInspector") String suggestionInspector) {

        SuggestionStructure suggestion = suggestionRepo.findById(suggestionId)
                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
        if (suggestion != null) {
            suggestion.setSuggestionStatus(statusRepo.getById(1L));
            suggestion.setSuggestionInspector(userRepo.findByEmail(suggestionInspector));
            suggestionRepo.save(suggestion);
            return ResponseEntity.ok("Предложение принято");
        } else {
            return ResponseEntity.badRequest().body("Предложение не найдено");
        }
    }

    @GetMapping("/suggestion/{emailAuthor}")
    public List<SuggestionStructure> getSuggestionsByEmail(@PathVariable ("emailAuthor") String email) {
        UserStructure user = userRepo.findByEmail(email);

        return suggestionRepo.findAllBySuggestionAuthor(user);
    }

    @GetMapping("/unchecked/suggestion/{emailInspector}")
    public List<SuggestionStructure> getUncheckedSuggestions(@PathVariable ("emailInspector") String email) {
        UserStructure user = userRepo.findByEmail(email);
        List<SuggestionStructure> suggestion = suggestionRepo.findAllBySuggestionInspector(user);
        List<SuggestionStructure> sortedSuggestion = new ArrayList<>();
        for (SuggestionStructure suggestionStructure : suggestion) {
            if (suggestionStructure.getSuggestionStatus().getId() == 0) {
                sortedSuggestion.add(suggestionStructure);
            }
        }
        return sortedSuggestion;
    }

}


