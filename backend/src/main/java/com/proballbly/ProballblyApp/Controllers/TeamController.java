package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Entities.Team;
import com.proballbly.ProballblyApp.Entities.User;
import com.proballbly.ProballblyApp.Repositories.TeamRepository;
import com.proballbly.ProballblyApp.Service.TeamService.TeamRepoService;
import com.sun.istack.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamRepository teamRepository;
    private final TeamRepoService teamRepoService;

    public TeamController(TeamRepository teamRepository, TeamRepoService teamRepoService) {
        this.teamRepository = teamRepository;
        this.teamRepoService = teamRepoService;
    }


    @GetMapping("/")
    public List<Team> getTeams(){
        List<Team> teams = new ArrayList<>();
        teamRepoService.findAll().forEach(teams::add);
        return teams;
    }

    @GetMapping("/{id}")
    @Nullable
    public Team getTeam(@PathVariable("id") Long id) {
        Optional<Team> optionalTeam = teamRepoService.findById(id);

        return optionalTeam.orElse(null);
    }

    @PostMapping(path = "/", consumes = "application/json")
    public void addTeam(@RequestBody Team team){
        this.teamRepository.save(team);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteTeam(@PathVariable Long id){
        teamRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
