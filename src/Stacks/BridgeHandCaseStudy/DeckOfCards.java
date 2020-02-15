package BridgeHands;

//Jacob Foster
//Professor Romanelli
//CSC 202
//February 4, 2020

//This class makes use of enumerations, generics, and the java provided abstraction of the stack interface to initialize a deck of cards

import ch02.StackUnderflowException;

import java.util.Stack;
import java.security.SecureRandom;

public class DeckOfCards<T>{
    private Stack<Card> deckOfCards; //Stack of cards
    private enum SUIT{
        HEARTS, SPADES, DIAMONDS, CLUBS //Enum of suits
    }
    private enum RANK{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACKS, QUEENS, KINGS, ACE, //enum of ranks
    }
git i
    public DeckOfCards(){ //initialize stack of cards by invoking constructor
        deckOfCards = new Stack<>();
        initDeck(); //call function to push each card onto the stack, initializing the deck of cards
    }

    public void initDeck(){ //function that initializes deck of card
        for(SUIT s : SUIT.values()){ //for each suit, loop through each rank and push all 52 cards onto the stack
            for(RANK r: RANK.values()){
                Card card = new Card(s,r); //card object
                deckOfCards.push(card); //pushes card onto the stack
            }
        }
    }

    public Stack<Card> shuffleDeck(Stack<Card> unshuffledDeck) throws StackUnderflowException { //functions that shuffles cards
        Stack<Card> shuffledDeck = new Stack(); //Shuffled Deck returned
        Stack<Card> tempDeck = new Stack(); //Temporary deck used for randomly generated pushed Cards
        SecureRandom rand = new SecureRandom(); // Secure random number generator
        Card temp; // temporary card used to push onto respective stack
        int random; // random int
        int tempDeckCounter = 0; //used to store the amount of remaining cards are to be pushed from tempDeck to shuffledDeck

        if(!unshuffledDeck.isEmpty()) {//pre condition that the stack must not be empty
            for (int i = 0; i < 52; i++) { // loop through 52 times
                random = rand.nextInt(17) + 1; //generate random number from 1 - 17
                if (random % 2 == 0) { //If number is even, move top of unshuffled deck to bottom of shuffled deck
                    temp = unshuffledDeck.pop(); //store card in temp variable and pop card from top of the stack
                    shuffledDeck.push(temp); //push stack on the top of shuffled deck

                } else if (!shuffledDeck.isEmpty()) { // If number is odd push card onto the temporary stack
                    temp = unshuffledDeck.pop(); //store card in temp variable; pops card from the argument
                    tempDeck.push(temp); //pushes card onto temporary stack
                    tempDeckCounter++; // increment the size of temporary stacks for preceding while loop to push these card onto the returned stack
                }
            }

            while (unshuffledDeck.size() < tempDeckCounter && !tempDeck.isEmpty()) { //assign remaining cards onto shuffledDeck
                temp = tempDeck.pop(); //store temp card
                shuffledDeck.push(temp); // push temp card onto final stack
            }
        } else throw new StackUnderflowException("You tried to shuffle a deck that is empty!");

        return shuffledDeck; //returns shuffled deck of cards
    }

    public Stack<Card> getDeckOfCards() {
        return deckOfCards; //returns stack of cards
    }

}
