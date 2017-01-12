package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private static String name = "Ace of Spades";
    private static JsonArray hole_cards;
    private static JsonObject aceofspace;

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject game = request.getAsJsonObject();

        if(game.get("bet_index").getAsInt() > 0) {
            System.err.println(game.get("community_cards").getAsJsonArray());
            System.err.println("CURRENT ROUND: " + game.get("bet_index"));
            System.err.println(game.get("community_cards").getAsJsonArray().size());
        }

        System.err.println(game.get("community_cards").getAsJsonArray().size());
        System.err.println("Community cards: KINCSI ::" + game.getAsJsonArray("community_cards"));
        System.err.println("Community cards: KINCSI ::::::::::::::::::::::::::::::::::::" + game.getAsJsonObject().toString());
        System.err.println("SSSSSSSSSSSSSSS" + game.getAsJsonObject("game_state"));

        int currentInActionBet = 0;
        int currentBuyIn = game.get("current_buy_in").getAsInt();
        int minimumRaise = game.get("minimum_raise").getAsInt();


        JsonArray players = game.get("players").getAsJsonArray();


        for(JsonElement player : players) {
            if (player.getAsJsonObject().get("id") == game.get("in_action")) {
                currentInActionBet = player.getAsJsonObject().get("bet").getAsInt();
            }
            if (player.getAsJsonObject().get("name").getAsString().equals("Ace Of Spades")) {
                aceofspace = player.getAsJsonObject();
                hole_cards = player.getAsJsonObject().get("hole_cards").getAsJsonArray();

                JsonObject card1 = hole_cards.get(0).getAsJsonObject();
                JsonObject card2 = hole_cards.get(1).getAsJsonObject();
                String rank1 = card1.get("rank").getAsString();
                String rank2 = card2.get("rank").getAsString();
                Map<String, Integer> converter = new HashMap<String, Integer>() {{
                    put("J", 6);
                    put("Q", 7);
                    put("K", 8);
                    put("A", 10);
                }};
                Integer rank1Int = converter.get(rank1);
                Integer rank2Int = converter.get(rank2);
                if (rank1Int == null) {
                    rank1Int = Integer.parseInt(rank1) / 2;
                }
                if (rank2Int == null) {
                    rank2Int = Integer.parseInt(rank2) / 2;
                }
                if (rank1Int + rank2Int > 8) {
                    if(players.size() < 4 || rank1.equals(rank2)) {
                        return currentBuyIn - currentInActionBet;
                    }
                }
            }

        }
        return 0;
    }

    public static void showdown(JsonElement game) {

    }


}
