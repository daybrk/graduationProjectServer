package com.example.graduationProjectServer.enity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SuggestionStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suggestionId;
    @Column(length = 2048)
    private String suggestion;
    private String suggestionTheme;
    private String suggestionDate;
    @OneToOne
    private Status suggestionStatus;
    @OneToOne
    private UserStructure suggestionAuthor;
    @OneToOne
    private UserStructure suggestionInspector;

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

    public UserStructure getSuggestionInspector() {
        return suggestionInspector;
    }

    public void setSuggestionInspector(UserStructure suggestionInspector) {
        this.suggestionInspector = suggestionInspector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuggestionStructure that = (SuggestionStructure) o;
        return suggestionId.equals(that.suggestionId) && suggestion.equals(that.suggestion) && suggestionTheme.equals(that.suggestionTheme) && suggestionDate.equals(that.suggestionDate) && suggestionStatus == that.suggestionStatus && suggestionAuthor.equals(that.suggestionAuthor) && suggestionInspector.equals(that.suggestionInspector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suggestionId, suggestion, suggestionTheme, suggestionDate, suggestionStatus, suggestionAuthor, suggestionInspector);
    }
}
