package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Entities.Teams;
import com.proballbly.ProballblyApp.Repositories.BPLTeamsRepository;
import com.proballbly.ProballblyApp.Service.FootballDataService;
import com.proballbly.ProballblyApp.Service.FootballDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FootballDataApi {

    private List<Teams> teamsList;

    @Autowired
    public FootballDataServiceImpl footballDataService;
    public BPLTeamsRepository repository;

    public FootballDataApi() {
        teamsList = new ArrayList<>();
        Teams teamX = new Teams(10000,"Wisla Krakow", "ABG");
        teamsList.add(teamX);


    }


    @GetMapping("/all")
    public Iterable<Teams> getAll() {
        return teamsList;
    }

//    @GetMapping
//    public FootballTeamBPL getById(@RequestParam int index) {
//        Optional<FootballTeamBPL> first = footballTeamBPLS.stream().
//                filter(element -> element.getId() == index).findFirst();
//        return first.get();
//    }
//
//    @PostMapping
//    public boolean addTeam(@RequestBody FootballTeamBPL footballTeamBPL)
//    {
//        return footballTeamBPLS.add(footballTeamBPL);
//    }
//
//    @PutMapping
//    public boolean updateTeam(@RequestBody FootballTeamBPL footballTeamBPL)
//    {
//        return true;
//    }
//
//    @DeleteMapping
//    public boolean deleteTeam(@RequestBody int index){
//        return true;
//    }

    @GetMapping("/teams")
    public List<Teams> teams() {
        return footballDataService.teams();
    }


    @GetMapping("/teams/{id}")
    public Teams team(@PathVariable String id) {
        return footballDataService.team(Integer.parseInt(id));
    }

}
