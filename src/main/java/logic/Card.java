package logic;

import com.google.gson.JsonObject;

public class Card {

    private int rank;
    private String suit;

    public Card(JsonObject card) {
        this.rank = RankConverter(card.get("rank").getAsString());
        this.suit = card.get("suit").getAsString();
    }

    public int RankConverter(String rank){
        if (rank.equals("A")) {
            return 14;
        }
        if (rank.equals("K")) {
            return 13;
        }
        if (rank.equals("Q")) {
            return 12;
        }
        if (rank.equals("J")) {
            return 11;
        }
        else {
            return Integer.parseInt(rank);
        }
    }

    public Integer getValue() {
        return rank;
    }

    public void setValue(Integer value) {
        this.rank = value;
    }

    public String getColor() {
        return suit;
    }

    public void setColor(String color) {
        this.suit = color;
    }

    public boolean colorMatch(Card c) {
        return this.getColor().equals(c.getColor());
    }

    public boolean valueMatch(Card c) {
        return this.getValue().equals(c.getValue());
    }

    public Integer distance(Card c) {
        return Math.abs(this.getValue() - c.getValue());
    }

    public boolean isFigure() {
        return this.rank > 10;
    }
}
