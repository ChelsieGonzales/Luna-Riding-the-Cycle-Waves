package Luna_periodTracker;

import java.time.LocalDate;

public class PeriodEntry {
    private LocalDate periodDate;
    private String mood;
    private String symptoms;
    private String digestion;

    // Constructor to match the parameters
    public PeriodEntry(LocalDate periodDate, String mood, String symptoms, String digestion) {
        this.periodDate = periodDate;
        this.mood = mood;
        this.symptoms = symptoms;
        this.digestion = digestion;
    }

    public LocalDate getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(LocalDate periodDate) {
        this.periodDate = periodDate;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDigestion() {
        return digestion;
    }

    public void setDigestion(String digestion) {
        this.digestion = digestion;
    }

    public LocalDate getDate() {
        return periodDate;
    }

    @Override
    public String toString() {
        return "Date: " + periodDate + 
        "\nMood: " + mood + 
        "\nSymptoms: " + symptoms + 
        "\nDigestion: " + digestion;
    }
}
