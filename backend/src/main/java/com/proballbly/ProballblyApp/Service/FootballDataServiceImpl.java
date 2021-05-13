package com.proballbly.ProballblyApp.Service;

import com.proballbly.ProballblyApp.Models.Competition;
import com.proballbly.ProballblyApp.Models.Teams;
import com.proballbly.ProballblyApp.Service.CompetitionService.CompetitionService;
import com.proballbly.ProballblyApp.Service.StandingService.StandingService;
import com.proballbly.ProballblyApp.Service.TeamService.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballDataServiceImpl implements FootballDataService {


    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private StandingService standingService;

    @Autowired
    private TeamService teamService;


    @Override
    public List<Competition> competitions() {
        return competitionService.load();
    }

    @Override
    public Competition competition(int id) {
        return competitionService.load(id);
    }

    @Override
    public String standings(int id) {
        return standingService.load(id);
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
