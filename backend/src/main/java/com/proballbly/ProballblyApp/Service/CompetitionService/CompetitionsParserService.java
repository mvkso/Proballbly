package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Models.Competition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CompetitionsParserService {
    private final JsonParser jsonParser = new JsonParser();
    private final CompetitionParser competitionParser = new CompetitionParser();


    public List<Competition> toCompetitions(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonElement competitionsJson = ((JsonObject) element).get("competitions");
        System.out.println(competitionsJson);
        if (competitionsJson.isJsonArray()) {
            return toCompetitions(competitionsJson.getAsJsonArray());
        }
        return toCompetitions(competitionsJson.getAsJsonObject());
    }


    public Competition toCompetition(String jsonString) {
        return competitionParser.toCompetition(jsonString);
    }

    private List<Competition> toCompetitions(JsonArray array) {
        List<Competition> competitions = new ArrayList<>();
        int i = 0;
        for(JsonElement element : array){
            JsonObject temp = element.getAsJsonObject();
            if(i!=37){
                competitions.add(toCompetition(temp));
            }
            i++;
        }
        return competitions;
    }

    private List<Competition> toCompetitions(JsonObject json) {
        return Collections.singletonList(toCompetition(json));
    }

    private Competition toCompetition(JsonObject json) {
        return competitionParser.toCompetition(json);
    }
}
