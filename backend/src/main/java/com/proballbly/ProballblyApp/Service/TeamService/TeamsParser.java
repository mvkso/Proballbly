package com.proballbly.ProballblyApp.Service.TeamService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Models.Teams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TeamsParser {

    private static final String FIELD_NAME = "teams";

    private final JsonParser jsonParser = new JsonParser();
    private final TeamParser teamParser = new TeamParser();



    public List <Teams> toTeams(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonObject object = element.getAsJsonObject();
        if (object.has(FIELD_NAME))
            return toTeams(object.get(FIELD_NAME).getAsJsonArray());
        return toTeams(object);
    }

    public Teams toTeam(String jsonString) {
        return teamParser.toTeam(jsonString);
    }

    private List<Teams> toTeams(JsonArray array) {
        List<Teams> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toTeam(item.getAsJsonObject())));
        return competitions;
    }

    private List<Teams> toTeams(JsonObject json) {
        return Collections.singletonList(toTeam(json));
    }

    private Teams toTeam(JsonObject json) {
        return teamParser.toTeam(json);
    }





}
