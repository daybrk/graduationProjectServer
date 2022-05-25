package com.example.graduationProjectServer.service;

import com.example.graduationProjectServer.enity.PushNotificationRequest;
import com.example.graduationProjectServer.firebase.FCMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PushNotificationService {

    private final Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private final FCMService fcmService;

    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    public void sendSamplePushNotification(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(getSamplePushNotificationRequest(request));
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage());
        }
    }

    private PushNotificationRequest getSamplePushNotificationRequest(PushNotificationRequest request) {
        return new PushNotificationRequest(request.getTitle(), request.getMessage(), request.getToken());
    }

}