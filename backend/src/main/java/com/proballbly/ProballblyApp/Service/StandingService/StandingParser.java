package com.proballbly.ProballblyApp.Service.StandingService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class StandingParser {

    private final JsonParser jsonParser = new JsonParser();

    public String toStanding (String jsonString){
        JsonElement element = jsonParser.parse(jsonString);
        JsonElement standingsJson = ((JsonObject) element).get("standings");

        return standingsJson.toString();
    }
}
