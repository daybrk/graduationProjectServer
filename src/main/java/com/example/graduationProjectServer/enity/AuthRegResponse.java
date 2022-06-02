package com.example.graduationProjectServer.enity;

public class AuthRegResponse {

    private String role;
    private String errorMessage;

    public AuthRegResponse(String role, String errorMessage) {
        this.role = role;
        this.errorMessage = errorMessage;
    }

    public AuthRegResponse(String role) {
        this.role = role;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
