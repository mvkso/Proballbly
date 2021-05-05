package com.proballbly.ProballblyApp.Service;

import com.proballbly.ProballblyApp.Entities.Competitions;
import com.proballbly.ProballblyApp.Entities.Teams;
import com.proballbly.ProballblyApp.Service.TeamService.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballDataServiceImpl implements FootballDataService {


    @Autowired
    private TeamService teamService;


    @Override
    public List<Competitions> competitions() {
        return null;
    }

    @Override
    public Competitions competition(int id) {
        return null;
    }

    @Override
    public String standings(int id) {
        return null;
    }

    @Override
    public List<Teams> teams() {
        return teamService.load();
    }

    @Override
    public List<Teams> competitionTeams(int id) {
        return teamService.loadCompetitionTeams(id);
    }

    @Override
    public Teams team(int id) {
        return teamService.load(id);
    }
}
