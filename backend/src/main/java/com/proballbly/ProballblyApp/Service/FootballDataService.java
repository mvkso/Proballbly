package com.proballbly.ProballblyApp.Service;

import com.proballbly.ProballblyApp.Entities.Competitions;
import com.proballbly.ProballblyApp.Entities.Teams;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FootballDataService {

    List <Competitions> competitions();

    Competitions competition(int id);

    String standings(int id);

    List<Teams> teams();

    List<Teams> competitionTeams(int id);

    Teams team(int id);


}
