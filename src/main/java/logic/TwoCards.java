package logic;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoCards {
    private ArrayList<Card> cardList = new ArrayList<>();

    public TwoCards(ArrayList<Card> list){
        this.cardList = list;
    }

    public int ChenStrategy(){
        float score = 0;
        int finalScore;
        Card highest;
        Card lowest;

        // find highest card
        if (cardList.get(0).getValue() < cardList.get(1).getValue()) {
            highest = cardList.get(1);
            lowest = cardList.get(0);
        }
        else {
            highest = cardList.get(0);
            lowest = cardList.get(1);
        }

        // score highest card
        if (highest.getValue() == 14){
            score += 10;
        }
        else if (highest.getValue() == 13){
            score += 8;
        }
        else if (highest.getValue() == 12){
            score += 7;
        }
        else if (highest.getValue() == 11){
            score += 6;
        }
        else {
            score += highest.getValue() / 2;
        }

        // get pairs and score
        if (cardList.get(0).getValue() == cardList.get(1).getValue()) {
            if (highest.getValue() > 2) {
                score += score;
            } else {
                score = 5;
            }
        }

        // score if suit match
        if (cardList.get(0).getColor() == cardList.get(1).getColor()) {
            score += 2;
        }

        // score difference
        int difference = highest.getValue() - lowest.getValue();
        if (difference == 0 && highest.getValue() >= 12) {
            score -= 0;
        }
        else if (difference == 0 && highest.getValue() < 12) {
            score += 1;
        }
        else if (difference == 1 && highest.getValue() >= 12) {
            score -= 0;
        }
        else if (difference == 1 && highest.getValue() < 12) {
            score += 1;
        }
        else if (difference == 2) {
            score -= 2;
        }
        else if (difference == 3) {
            score -= 4;
        }
        else {
            score -= 5;
        }

        finalScore = (int) Math.ceil(score);

        return finalScore;

    }

    //JsonObject card1 = hole_cards.get(0).getAsJsonObject();
    //JsonObject card2 = hole_cards.get(1).getAsJsonObject();

}
