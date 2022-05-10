package com.example.graduationProjectServer.enity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SuggestionStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suggestionId;
    private String suggestion;
    private String suggestionTheme;
    private String suggestionDate;
    private Status suggestionStatus;
    @OneToOne
    private UserStructure suggestionAuthor;

    public SuggestionStructure(String suggestionTheme, String suggestion, String suggestionDate,
                               Status suggestionStatus, UserStructure suggestionAuthor) {
        this.suggestion = suggestion;
        this.suggestionDate = suggestionDate;
        this.suggestionStatus = suggestionStatus;
        this.suggestionTheme = suggestionTheme;
        this.suggestionAuthor = suggestionAuthor;
    }

    public SuggestionStructure() {

    }

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

    public UserStructure getSuggestionAuthor() {
        return suggestionAuthor;
    }

    public void setSuggestionAuthor(UserStructure suggestionAuthor) {
        this.suggestionAuthor = suggestionAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuggestionStructure that = (SuggestionStructure) o;
        return suggestionId.equals(that.suggestionId) && suggestion.equals(that.suggestion) &&
                suggestionDate.equals(that.suggestionDate) && suggestionStatus == that.suggestionStatus &&
                suggestionTheme.equals(that.suggestionTheme) && suggestionAuthor.equals(that.suggestionAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suggestionId, suggestion, suggestionDate, suggestionStatus, suggestionTheme, suggestionAuthor);
    }
}
