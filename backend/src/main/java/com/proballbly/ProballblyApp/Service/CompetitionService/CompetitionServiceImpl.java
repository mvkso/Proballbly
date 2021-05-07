package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.proballbly.ProballblyApp.Entities.Competitions;
import com.proballbly.ProballblyApp.Service.EndpointProviderService;
import com.proballbly.ProballblyApp.Service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionsParserService parser;

    @Autowired
    private EndpointProviderService endpointProviderService;

    @Autowired
    private RestClientService restClientService;


    @Override
    public List<Competitions> load() {

        String s = restClientService.get(endpointProviderService.getCompetitions());
        return parser.toCompetitions(s);
    }

    @Override
    public Competitions load(int id) {
        String endpoint = endpointProviderService.getCompetition(id);
        String s = restClientService.get(endpoint);
        return parser.toCompetition(s);
    }
}
