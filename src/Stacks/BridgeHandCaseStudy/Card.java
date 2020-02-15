package BridgeHands;


//Card Object that will be initialized and pushed onto the deck of cards

public class Card<T> {
    private T rank;
    private T suit;

    public Card(T suit, T rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public T getRank() {
        return rank;
    }

    public void setRank(T rank) {
        this.rank = rank;
    }

    public T getSuit() {
        return suit;
    }

    public void setSuit(T suit) {
        this.suit = suit;
    }


    @Override
    public String toString() {
        return "Card: " + rank + " of " + suit; //Outputs current card on the stack as a string representation
    }
}