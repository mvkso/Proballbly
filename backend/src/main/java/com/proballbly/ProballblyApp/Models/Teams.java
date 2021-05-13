package com.proballbly.ProballblyApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String shortName;

    public Teams() {

    }

    public Teams(TeamsBuilder builder) {
        this.id=builder.id;
        this.name=builder.name;
        this.shortName=builder.shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }

    public static TeamsBuilder builder() {
        return new TeamsBuilder();
    }

    public static class TeamsBuilder{
        private int id;
        private String name;
        private String shortName;

        public TeamsBuilder id(int id) {
            this.id = id;
            return this;
        }

        public TeamsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TeamsBuilder shortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Teams build() {
            return new Teams(this);
        }
    }
}
