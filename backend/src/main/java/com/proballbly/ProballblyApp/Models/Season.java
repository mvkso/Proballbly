package com.proballbly.ProballblyApp.Models;

import java.time.LocalDate;

//@Entity
public class Season {
    private final int id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int currentMatchDay;

    private Season(SeasonBuilder seasonBuilder) {
        this.id = seasonBuilder.id;
        this.startDate = seasonBuilder.startDate;
        this.endDate = seasonBuilder.endDate;
        this.currentMatchDay = seasonBuilder.currentMatchDay;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public static SeasonBuilder builder() {
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
}
