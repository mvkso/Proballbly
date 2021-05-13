package com.proballbly.ProballblyApp.Service;

import com.proballbly.ProballblyApp.Models.Competition;
import com.proballbly.ProballblyApp.Models.Teams;

import java.util.List;


public interface FootballDataService {

    List <Competition> competitions();

    Competition competition(int id);

    String standings(int id);

    List<Teams> teams();

    List<Teams> competitionTeams(int id);

    Teams team(int id);


}
