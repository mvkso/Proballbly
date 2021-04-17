package com.proballbly.ProballblyApp.Entities;

import javax.persistence.*;

@Entity
public class BPLMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seasonId;
    private int matchDay;
    private int homeTeamId;
    private int awayTeamId;

    public BPLMatch(int id, int seasonId, int matchDay, int homeTeamId, int awayTeamId) {
        this.id = id;
        this.seasonId = seasonId;
        this.matchDay = matchDay;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
    }

    public BPLMatch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    @Override
    public String toString() {
        return "BPLMatch{" +
                "id=" + id +
                ", seasonId=" + seasonId +
                ", matchDay=" + matchDay +
                ", homeTeamId=" + homeTeamId +
                ", awayTeamId=" + awayTeamId +
                '}';
    }
}
