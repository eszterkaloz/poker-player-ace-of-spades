package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.ir.IfNode;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        System.err.println("Dani log" + request.toString());
        JsonObject game = request.getAsJsonObject();

        int currentBuyIn = game.get("current_buy_in").getAsInt();

        int minimumRaise = game.get("minimum_raise").getAsInt();

        System.err.println("Eszter log players" + game.get("players").getAsJsonArray());
        System.err.println("Balazs log " + game.get("current_buy_in").getAsInt());
        System.err.println("Balazs log " + game.get("minimum_raise").getAsInt());
        System.err.println("Eszter log " + game.get("community_cards").getAsJsonArray());
        System.err.println("HOLE CARDS" + game.get("game_id").getAsString());
        JsonArray players = game.get("community_cards").getAsJsonArray();
        for(JsonElement player : players){
            System.err.println(player);

        }

        return 100;
    }

    public static void showdown(JsonElement game) {
        System.err.println("Eszter log (name)" + game.getAsJsonObject().get("name"));
        System.err.println("Eszter log" +game.toString());

    }
}
