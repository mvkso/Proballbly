package com.proballbly.ProballblyApp.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BPLStandings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int position;
    private int teamId;
    private String teamName;
    private int won;
    private int draw;
    private int lost;
    private int points;
    private int goalsFor;
    private int goalsAgaints;
    private int goalsDifference;


    public BPLStandings(int id, int position, int teamId, String teamName, int won, int draw, int lost, int points, int goalsFor, int goalsAgaints, int goalsDifference) {
        this.id = id;
        this.position = position;
        this.teamId = teamId;
        this.teamName = teamName;
        this.won = won;
        this.draw = draw;
        this.lost = lost;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgaints = goalsAgaints;
        this.goalsDifference = goalsDifference;
    }

    public BPLStandings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgaints() {
        return goalsAgaints;
    }

    public void setGoalsAgaints(int goalsAgaints) {
        this.goalsAgaints = goalsAgaints;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public void setGoalsDifference(int goalsDifference) {
        this.goalsDifference = goalsDifference;
    }

    @Override
    public String toString() {
        return "BPLStandings{" +
                "id=" + id +
                ", position=" + position +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", won=" + won +
                ", draw=" + draw +
                ", lost=" + lost +
                ", points=" + points +
                ", goalsFor=" + goalsFor +
                ", goalsAgaints=" + goalsAgaints +
                ", goalsDifference=" + goalsDifference +
                '}';
    }
}

