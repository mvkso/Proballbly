package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Entities.Competitions;
import com.proballbly.ProballblyApp.Entities.Season;
import com.proballbly.ProballblyApp.Service.JsonExtractor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompetitionParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Competitions toCompetitions(String jsonString){
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetitions(json);
    }

    public Competitions toCompetitions(JsonObject json){
        Competitions x = Competitions.builder()
                .id(parseId(json))
                .name(parseName(json))
                .currentSeason(parseSeason(extractor.extractJson(json, "currentSeason")))
                .lastUpdated(parseLastUpdated(json))
                .build();
        return x;
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private Season parseSeason(JsonObject json) {
        return Season.builder()
                .id(parseId(json))
                .currentMatchDay(parseCurrentMatchDay(json))
                .startDate(parseStartDate(json))
                .endDate(parseEndDate(json))
                .build();
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private LocalDate parseStartDate(JsonObject json) {
        return extractor.extractLocalDate(json, "startDate");
    }

    private LocalDate parseEndDate(JsonObject json) {
        return extractor.extractLocalDate(json, "endDate");
    }

    private int parseCurrentMatchDay(JsonObject json) {
        return extractor.extractInt(json, "currentMatchDay");
    }

    private LocalDateTime parseLastUpdated(JsonObject json) {
        return extractor.extractDateTime(json, "lastUpdated");
    }



}
