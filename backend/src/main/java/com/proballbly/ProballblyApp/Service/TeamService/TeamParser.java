package com.proballbly.ProballblyApp.Service.TeamService;

import com.proballbly.ProballblyApp.Service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Entities.Teams;

public class TeamParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Teams toTeam(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toTeam(json);
    }
    public Teams toTeam(JsonObject json){
            Teams x =  Teams.builder()
                .id(parseId(json))
                .name(parseName(json))
                .shortName(parseShortName(json))
                .build();
            return x;


    }
    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parseShortName(JsonObject json) {
        return extractor.extractString(json, "shortName");
    }

}
