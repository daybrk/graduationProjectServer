package com.example.graduationProjectServer.controller;


import com.example.graduationProjectServer.enity.PushNotificationRequest;
import com.example.graduationProjectServer.enity.PushNotificationResponse;
import com.example.graduationProjectServer.enity.UserRole;
import com.example.graduationProjectServer.enity.UserStructure;
import com.example.graduationProjectServer.repository.*;
import com.example.graduationProjectServer.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableScheduling
public class PushNotificationController {

    @Autowired
    private SuggestionRepo suggestionRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private RolesRepo rolesRepo;
    private final PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    int count = 0;
    @Scheduled(fixedDelay = 60000)
    public void sendSampleNotification() {
        // Вылетает ошибка из-за несоответсвия передаваемому id с id в таблице
        List<UserRole> usersWithRoles = userRoleRepo.findAllByRoleIdEquals(rolesRepo.getById(2L));
        List<UserStructure> moderators = new ArrayList<>();
        for (UserRole sortedSuggestion : usersWithRoles) {
            moderators.add(sortedSuggestion.getUserEmail());
        }
        System.out.println(suggestionRepo.countBySuggestionInspectorAndSuggestionStatusEquals(moderators.get(count), statusRepo.getById(0L)));
        pushNotificationService.sendSamplePushNotification(
                 new PushNotificationRequest(
                         "У вас скопились непроверенные предложения " + moderators.get(count).getName() + "!",
                         "Новых предложений: " + suggestionRepo.countBySuggestionInspectorAndSuggestionStatusEquals(moderators.get(count), statusRepo.getById(0L)),
                         moderators.get(count).getToken()));
        if (count >= moderators.size() - 1) {
            count = 0;
        } else {
            count++;
        }
    }
}