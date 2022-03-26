package com.example.graduationProjectServer.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SuggestionStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suggestionId;
    private String suggestion;
    private String suggestionDate;
    private String suggestionStatus;
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

    public String getSuggestionStatus() {
        return suggestionStatus;
    }

    public void setSuggestionStatus(String suggestionStatus) {
        this.suggestionStatus = suggestionStatus;
    }

    public String getSuggestionTheme() {
        return suggestionTheme;
    }

    public void setSuggestionTheme(String suggestionTheme) {
        this.suggestionTheme = suggestionTheme;
    }

    public String getSuggestionAuthor() {
        return suggestionAuthor;
    }

    public void setSuggestionAuthor(String suggestionAuthor) {
        this.suggestionAuthor = suggestionAuthor;
    }


}
