package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Entities.Competitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompetitionParserServiceImpl implements CompetitionsParserService {
    private final JsonParser jsonParser = new JsonParser();
    private final CompetitionParser competitionParser = new CompetitionParser();

    @Override
    public List<Competitions> toCompetitions(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonElement competitionsJson = ((JsonObject) element).get("competitions");
        if (competitionsJson.isJsonArray())
            return toCompetitions(competitionsJson.getAsJsonArray());
        return toCompetitions(competitionsJson.getAsJsonObject());
    }

    @Override
    public Competitions toCompetition(String jsonString) {
        return competitionParser.toCompetitions(jsonString);
    }

    private List<Competitions> toCompetitions(JsonArray array) {
        List<Competitions> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toCompetition(item.getAsJsonObject())));
        return competitions;
    }

    private List<Competitions> toCompetitions(JsonObject json) {
        return Collections.singletonList(toCompetition(json));
    }

    private Competitions toCompetition(JsonObject json) {
        return competitionParser.toCompetitions(json);
    }
}
