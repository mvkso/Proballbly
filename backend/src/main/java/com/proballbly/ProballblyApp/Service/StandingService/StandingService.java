package com.proballbly.ProballblyApp.Service.StandingService;

import com.proballbly.ProballblyApp.Service.EndpointProviderService;
import com.proballbly.ProballblyApp.Service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingService {

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private EndpointProviderService endpointProviderService;

    public String load(int id) {
        return restClientService.get(endpointProviderService.getStandings(id));
    }

}
