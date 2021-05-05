package com.proballbly.ProballblyApp.Service.TeamService;


import com.proballbly.ProballblyApp.Entities.Teams;
import com.proballbly.ProballblyApp.Repositories.BPLTeamsRepository;
import com.proballbly.ProballblyApp.Service.EndpointProviderService;
import com.proballbly.ProballblyApp.Service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private TeamsParser parser = new TeamsParser();

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private EndpointProviderService endpointProviderService;

    @Autowired
    private BPLTeamsRepository repository;//

    public List<Teams> load(){
        String endpoint = endpointProviderService.getTeams();
        String jsonString = restClientService.get(endpoint);
        return parser.toTeams(jsonString);
    }


    public List<Teams> loadCompetitionTeams(int competitionId) {
        String endpoint = endpointProviderService.getTeams(competitionId);
        String jsonString = restClientService.get(endpoint);
        return parser.toTeams(jsonString);
    }

    public Teams load(int teamId) {
        String endpoint = endpointProviderService.getTeam(teamId);
        String jsonString = restClientService.get(endpoint);
        return parser.toTeam(jsonString);
    }

}
