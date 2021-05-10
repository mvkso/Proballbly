package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Entities.Competition;
import com.proballbly.ProballblyApp.Entities.Teams;
import com.proballbly.ProballblyApp.Service.FootballDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class FootballDataApi {


    @Autowired
    public FootballDataServiceImpl footballDataService;

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
        return footballDataService.standings(Integer.parseInt(id));
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
