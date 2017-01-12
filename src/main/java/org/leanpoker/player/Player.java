package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import logic.GameController;

public class Player {
    private static String name = "Ace of Spades";
    private static JsonArray hole_cards;
    private static JsonObject aceofspace;

    static final String VERSION = "If you like to gamble, I tell you I'm your man\n" +
            "you win some, lose some, it's all the same to me\n" +
            "The pleasure is to play, it makes no difference what you say\n" +
            "I don't share your greed, the only card I need is\n" +
            "the Ace of Spades\n" +
            "the Ace of Spades\n" +
            "copyright <a href=\"http://elyrics.net\">http://elyrics.net</a>";

    public static int betRequest(JsonElement request) {
        JsonObject game = request.getAsJsonObject();
        GameController controller = new GameController(game);

        int returnValue;
        returnValue = controller.Strategy();

        return returnValue;
        


        /*
        int currentInActionBet = 0;
        int currentBuyIn = game.get("current_buy_in").getAsInt();
        int minimumRaise = game.get("minimum_raise").getAsInt();

        JsonArray players = game.get("players").getAsJsonArray();


        if (players.size() < 4) {
            for (JsonElement player : players) {
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

                    //                return aceofspace.get("stack").getAsInt();
                    Integer rank1Int = converter.get(rank1);
                    Integer rank2Int = converter.get(rank2);
                    if (rank1Int == null) {
                        rank1Int = Integer.parseInt(rank1) / 2;
                    }
                    if (rank2Int == null) {
                        rank2Int = Integer.parseInt(rank2) / 2;
                    }
                    if (rank1Int + rank2Int > 8) {
                        return currentBuyIn - currentInActionBet;
                    }
                }

            }
        }
        return 0;
        */
    }

    public static void showdown(JsonElement game) {

    }


}
