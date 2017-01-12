package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.ir.IfNode;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Map;

public class Player {
    private static String name = "Ace of Spades";
    private static JsonArray hole_cards;
    private static JsonObject aceofspace;

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject game = request.getAsJsonObject();


        System.err.println("Community cards: KINCSI ::" + game.getAsJsonArray("community_cards"));
        System.err.println("Community cards: KINCSI ::::::::::::::::::::::::::::::::::::" + game.getAsString());

        int currentInActionBet = 0;
        int currentBuyIn = game.get("current_buy_in").getAsInt();
        int minimumRaise = game.get("minimum_raise").getAsInt();


        JsonArray players = game.get("players").getAsJsonArray();

        for(JsonElement player : players){
            if(player.getAsJsonObject().get("id") == game.get("in_action")) {
                currentInActionBet = player.getAsJsonObject().get("bet").getAsInt();
            }
            if(player.getAsJsonObject().get("name").getAsString().equals("Ace Of Spades")) {
                aceofspace = player.getAsJsonObject();
                hole_cards = player.getAsJsonObject().get("hole_cards").getAsJsonArray();

                JsonObject card1 = hole_cards.get(0).getAsJsonObject();
                JsonObject card2 = hole_cards.get(1).getAsJsonObject();
                if (card1.get("rank").getAsString().equals(card2.get("rank").getAsString())) return currentBuyIn - currentInActionBet;
            }
        }
        return 0;
    }

    public static void showdown(JsonElement game) {

    }
}
