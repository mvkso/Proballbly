package com.proballbly.ProballblyApp.Service.TeamService;

import com.proballbly.ProballblyApp.Entities.Team;
import com.proballbly.ProballblyApp.Entities.User;
import com.proballbly.ProballblyApp.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamRepoService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamRepoService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public Optional<Team> findById(Long id){return teamRepository.findById(id);}

    public Iterable<Team> findAll() { return teamRepository.findAll(); }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }


}
