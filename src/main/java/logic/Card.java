package logic;

public class Card {

    private Integer value;
    private String color;

    public Card(Integer value, String color) {
        this.value = value;
        this.color = color;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return this.value > 10;
    }
}
