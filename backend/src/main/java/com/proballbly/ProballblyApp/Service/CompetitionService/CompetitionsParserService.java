package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.proballbly.ProballblyApp.Entities.Competitions;

import java.util.List;

public interface CompetitionsParserService {

    List<Competitions> toCompetitions(String jsonString);

    Competitions toCompetition(String jsonString);
}
