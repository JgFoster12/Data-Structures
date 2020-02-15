/* Jacob Foster
* Professor Romanelli
* CSC 202
* February 15, 2020*/

package BridgeHands;

import java.util.Stack;

public class BridgeHandDriver {
    //initiate four stacks representing each hand
    static Stack<Card> north = new Stack();
    static Stack<Card> south = new Stack();
    static Stack<Card> east = new Stack();
    static Stack<Card> west = new Stack();

    public static void main(String[] args) {
        DeckOfCards newDeck = new DeckOfCards(); //initiates new deck of cards
        Stack<Card> theStack = newDeck.getDeckOfCards(); // initiates stack
        theStack = newDeck.shuffleDeck(theStack); //shuffles the deck of cards

        System.out.println(theStack); //prints the shuffled deck of cards

        dealCards(theStack); //deals the cards

        //prints each hand
        System.out.println("North Hand: " + north.toString());
        System.out.println("West Hand: " + west.toString());
        System.out.println("South Hand: " + south.toString());
        System.out.println("East Hand: " + east.toString());


    }
    //algorithm to deal the cards
    public static void dealCards(Stack<Card> stack){
        Card temp; //temporary card to make code more readable
        for(int i = 0; i < 52; i+=4){ //loop through each card and increment by four each time since four cards are being dealt
            //simply pop a card off the deck, assign it to the temporary variable, and push the card onto respective hand
            temp = stack.pop();
            north.push(temp);
            temp = stack.pop();
            east.push(temp);
            temp=stack.pop();
            south.push(temp);
            temp = stack.pop();
            west.push(temp);
        }
    }
}









