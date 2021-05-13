package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Models.Competition;
import com.proballbly.ProballblyApp.Models.Teams;
import com.proballbly.ProballblyApp.Service.FootballDataServiceImpl;
import com.proballbly.ProballblyApp.Service.StandingService.StandingParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class FootballDataApi {


    @Autowired
    public FootballDataServiceImpl footballDataService;

    @Autowired
    public StandingParser parser;

    @GetMapping("/competitions")
    public List<Competition> competitions() {
        return footballDataService.competitions();
    }


    @GetMapping("/competitions/{id}")
    public Competition competition(@PathVariable String id) {
        return footballDataService.competition(Integer.parseInt(id));
    }

    @GetMapping("/competitions/{id}/standings")
    public String standings(@PathVariable String id) {
        String standing = footballDataService.standings(Integer.parseInt(id));
        return parser.toStanding(standing);
    }

    @GetMapping("/teams")
    public List<Teams> teams() {
        return footballDataService.teams();
    }

    @GetMapping("/competitions/{id}/teams")
    public List<Teams> competitionTeams(@PathVariable String id) {
        return footballDataService.competitionTeams(Integer.parseInt(id));
    }

    @GetMapping("/teams/{id}")
    public Teams team(@PathVariable String id) {
        return footballDataService.team(Integer.parseInt(id));

    }


}
