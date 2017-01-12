package logic;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class GameController {
    JsonObject game;
    JsonArray players;
    int currentBuyIn;
    int minimumRaise;
    int currentInActionBet;
    public ArrayList<Card> cardList = new ArrayList<>();


    public GameController(JsonObject game){
        this.game = game;
        this.players = game.get("players").getAsJsonArray();
        this.InitCardList();
        this.currentBuyIn = game.get("current_buy_in").getAsInt();
        this.minimumRaise = game.get("minimum_raise").getAsInt();
    }

    public void InitCardList(){
        for(JsonElement player : this.players){
            if(player.getAsJsonObject().get("id") == game.get("in_action")) {
                currentInActionBet = player.getAsJsonObject().get("bet").getAsInt();
            }

            if(player.getAsJsonObject().get("name").getAsString().equals("Ace Of Spades")) {
                JsonArray hole_cards = player.getAsJsonObject().get("hole_cards").getAsJsonArray();
                JsonObject card1 = hole_cards.get(0).getAsJsonObject();
                JsonObject card2 = hole_cards.get(1).getAsJsonObject();
                Card cardObject1 = new Card(card1);
                this.cardList.add(cardObject1);
                Card cardObject2 = new Card(card2);
                this.cardList.add(cardObject2);
            }
        }
    }

    public int Strategy(){
        if (cardList.size() == 2) {
            TwoCards two = new TwoCards(cardList);
            int score = two.ChenStrategy();

            if (score >= 9) {
                // raise
                return currentBuyIn - currentInActionBet + minimumRaise;
            }
            else {
                // fold
                return 0;
            }

        // this should never run...
        } else {
            return 0;
        }
    }

}
