package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.proballbly.ProballblyApp.Models.Competition;
import com.proballbly.ProballblyApp.Service.EndpointProviderService;
import com.proballbly.ProballblyApp.Service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionsParserService parser;

    @Autowired
    private EndpointProviderService endpointProviderService;

    @Autowired
    private RestClientService restClientService;


    public List<Competition> load() {

        String s = restClientService.get(endpointProviderService.getCompetitions());
        return parser.toCompetitions(s);
    }

    public Competition load(int id) {
        String endpoint = endpointProviderService.getCompetition(id);
        String s = restClientService.get(endpoint);
        return parser.toCompetition(s);
    }
}
