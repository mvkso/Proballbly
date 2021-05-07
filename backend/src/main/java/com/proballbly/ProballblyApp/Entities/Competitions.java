package com.proballbly.ProballblyApp.Entities;


import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Competitions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(mappedBy = "competitions")
    private Season currentSeason;

    private LocalDateTime lastUpdated;
    

    public Competitions(CompetitionsBuilder builder) {
        this.id=builder.id;
        this.name = builder.name;
        this.currentSeason=builder.currentSeason;
        this.lastUpdated = builder.lastUpdated;

    }

    public Competitions() {
    }


    public static CompetitionsBuilder builder() {
        return new CompetitionsBuilder();
    }

    public static class CompetitionsBuilder{

        private int id;
        private String name;
        private Season currentSeason;
        private LocalDateTime lastUpdated;

        public CompetitionsBuilder id(int id){
            this.id = id;
            return this;
        }
        public CompetitionsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompetitionsBuilder currentSeason(Season currentSeason) {
            this.currentSeason = currentSeason;
            return this;
        }

        public CompetitionsBuilder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }
        public Competitions build() {
            return new Competitions(this);
        }


    }
}




