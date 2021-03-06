package com.proballbly.ProballblyApp.Service.CompetitionService;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proballbly.ProballblyApp.Models.Area;
import com.proballbly.ProballblyApp.Models.Competition;
import com.proballbly.ProballblyApp.Models.Season;
import com.proballbly.ProballblyApp.Service.JsonExtractor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompetitionParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Competition toCompetition(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetition(json);
    }

    public Competition toCompetition(JsonObject json) {
        return Competition.builder()
                .id(parseId(json))
                .area(parseArea(json))
                .name(parseName(json))
                .plan(parsePlan(json))
                .code(parseCode(json))
                .currentSeason(parseSeason(extractor.extractJson(json, "currentSeason")))
                .numberOfAvailableSeasons(parseNumberOfAvailableSeasons(json))
                .seasons(parseSeasons(json))
                .lastUpdated(parseLastUpdated(json))
                .build();
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private Area parseArea(JsonObject json) {
        JsonObject area = extractor.extractJson(json, "area");
        return Area.builder()
                .id(parseId(area))
                .name(parseName(area))
                .build();
    }

    private Season parseSeason(JsonObject json) {
        return Season.builder()
                .id(parseId(json))
                .currentMatchDay(parseCurrentMatchDay(json))
                .startDate(parseStartDate(json))
                .endDate(parseEndDate(json))
                .build();
    }

    private List<Season> parseSeasons(JsonObject json) {
        List<Season> seasons = new ArrayList<>();
        List<JsonObject> seasonsJson = extractor.extractList(json, "seasons");
        seasonsJson.forEach(item -> seasons.add(parseSeason(item)));
        return seasons;
    }


    private int parseNumberOfAvailableSeasons(JsonObject json) {
        return extractor.extractInt(json, "numberOfAvailableSeasons");
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parsePlan(JsonObject json) {
        return extractor.extractString(json, "plan");
    }

    private String parseCode(JsonObject json) {
        return extractor.extractString(json, "code");
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
