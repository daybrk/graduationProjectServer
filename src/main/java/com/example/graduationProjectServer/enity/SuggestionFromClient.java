package com.example.graduationProjectServer.enity;


public class SuggestionFromClient {
    private Long suggestionId;
    private String suggestion;
    private String suggestionDate;
    private Status suggestionStatus;
    private String suggestionTheme;
    private String suggestionAuthor;

    public Long getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSuggestionDate() {
        return suggestionDate;
    }

    public void setSuggestionDate(String suggestionDate) {
        this.suggestionDate = suggestionDate;
    }

    public String getSuggestionTheme() {
        return suggestionTheme;
    }

    public void setSuggestionTheme(String suggestionTheme) {
        this.suggestionTheme = suggestionTheme;
    }

    public Status getSuggestionStatus() {
        return suggestionStatus;
    }

    public void setSuggestionStatus(Status suggestionStatus) {
        this.suggestionStatus = suggestionStatus;
    }

    public String getSuggestionAuthor() {
        return suggestionAuthor;
    }

    public void setSuggestionAuthor(String suggestionAuthor) {
        this.suggestionAuthor = suggestionAuthor;
    }
}
