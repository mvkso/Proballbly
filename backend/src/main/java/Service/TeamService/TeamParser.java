package Service.TeamService;

import Service.JsonExtractor;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TeamParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

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
