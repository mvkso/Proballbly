package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.proballbly.ProballblyApp.Entities.Competitions;

import java.util.List;

public interface CompetitionService {

    List<Competitions> load();

    Competitions load(int id);
}
