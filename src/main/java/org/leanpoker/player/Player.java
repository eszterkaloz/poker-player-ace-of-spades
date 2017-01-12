package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        System.err.println(request.toString());
        System.err.println("Some basic log ");
        return 100;
    }

    public static void showdown(JsonElement game) {
        System.err.println(game.getAsJsonObject().get("players"));
        System.err.println(game.toString());
    }
}
