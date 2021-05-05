package com.proballbly.ProballblyApp.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competitions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int currentSeasonId;
    private int currentMatchDay;
    private int seasonsId;

    public Competitions(int id, String name, int currentSeasonId, int currentMatchDay, int seasonsId) {
        this.id = id;
        this.name = name;
        this.currentSeasonId = currentSeasonId;
        this.currentMatchDay = currentMatchDay;
        this.seasonsId = seasonsId;
    }

    public Competitions() {
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

    public int getCurrentSeasonId() {
        return currentSeasonId;
    }

    public void setCurrentSeasonId(int currentSeasonId) {
        this.currentSeasonId = currentSeasonId;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public void setCurrentMatchDay(int currentMatchDay) {
        this.currentMatchDay = currentMatchDay;
    }

    public int getSeasonsId() {
        return seasonsId;
    }

    public void setSeasonsId(int seasonsId) {
        this.seasonsId = seasonsId;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentSeasonId=" + currentSeasonId +
                ", currentMatchDay=" + currentMatchDay +
                ", seasonsId=" + seasonsId +
                '}';
    }
}
