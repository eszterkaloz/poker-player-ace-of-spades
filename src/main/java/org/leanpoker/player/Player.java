package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        System.err.println("Dani log" + request.toString());
        System.err.println("Some basic log ");
        JsonObject game = request.getAsJsonObject();
        System.err.println("Balazs log " + game.get("current_buy_in").getAsInt());
        System.err.println("Balazs log " + game.get("minimum_raise").getAsInt());
        System.err.println("Eszter log " + game.get("community_cards").getAsJsonArray().get(0));
        return 100;
    }

    public static void showdown(JsonElement game) {
        System.err.println("Eszter log (name)" + game.getAsJsonObject().get("name"));
        System.err.println("Eszter log" +game.toString());

    }
}
