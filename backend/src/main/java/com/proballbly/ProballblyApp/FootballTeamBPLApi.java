package com.proballbly.ProballblyApp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bpl")
@CrossOrigin
public class FootballTeamBPLApi {

    private List<FootballTeamBPL> footballTeamBPLS;

    public FootballTeamBPLApi() {
        footballTeamBPLS = new ArrayList<>();
        footballTeamBPLS.add(new FootballTeamBPL(1, "Manchester United"));
        footballTeamBPLS.add(new FootballTeamBPL(2, "Liverpool FC"));
    }

    @GetMapping("/all")
    public List<FootballTeamBPL> getAll() {
        return footballTeamBPLS;
    }

    @GetMapping
    public FootballTeamBPL getById(@RequestParam int index) {
        Optional<FootballTeamBPL> first = footballTeamBPLS.stream().
                filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addTeam(@RequestBody FootballTeamBPL footballTeamBPL)
    {
        return footballTeamBPLS.add(footballTeamBPL);
    }

    @PutMapping
    public boolean updateTeam(@RequestBody FootballTeamBPL footballTeamBPL)
    {
        return footballTeamBPLS.add(footballTeamBPL);
    }

    @DeleteMapping
    public boolean deleteTeam(@RequestBody int index){
        return footballTeamBPLS.removeIf(element -> element.getId() == index);
    }

}
