package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Integer> sorted(){
        List<Integer> values = new ArrayList<>();
        for (Card c : this.cards){
            if (!values.contains(c.getValue())) values.add(c.getValue());
        }
        Collections.sort(values);
        return values;
    }

    public Integer highestCard() {
        return this.sorted().get(0);
    }

    public Integer countColour(String color){
        Integer result = 0;
        for (Card c : this.cards) {
            if (c.getColor().equals(color)) result++;
        }
        return result;
    }

}
