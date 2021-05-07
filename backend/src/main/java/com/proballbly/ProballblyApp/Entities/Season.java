package com.proballbly.ProballblyApp.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;
    private int currentMatchDay;

    @OneToOne
    Competitions competitions;

    private Season(SeasonBuilder seasonBuilder) {
        this.id = seasonBuilder.id;
        this.startDate = seasonBuilder.startDate;
        this.endDate = seasonBuilder.endDate;
        this.currentMatchDay = seasonBuilder.currentMatchDay;
    }

    public Season() {
    }

    public static SeasonBuilder builder(){
        return new SeasonBuilder();
    }



    public static class SeasonBuilder {
        private int id;
        private LocalDate startDate;
        private LocalDate endDate;
        private int currentMatchDay;

        public SeasonBuilder id(int id) {
            this.id = id;
            return this;
        }

        public SeasonBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public SeasonBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public SeasonBuilder currentMatchDay(int currentMatchDay) {
            this.currentMatchDay = currentMatchDay;
            return this;
        }

        public Season build() {
            return new Season(this);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public void setCurrentMatchDay(int currentMatchDay) {
        this.currentMatchDay = currentMatchDay;
    }

    public Competitions getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Competitions competitions) {
        this.competitions = competitions;
    }
}
