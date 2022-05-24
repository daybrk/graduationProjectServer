package com.example.graduationProjectServer.enity;

public class PushNotificationRequest {

    private String title;
    private String message;
    private String token;

    private String topic;
    public PushNotificationRequest() {
    }

    public PushNotificationRequest(String title, String message, String token) {
        this.title = title;
        this.message = message;
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}