/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class GoFishPlayer extends Player{

    private CardHand hand;
    private ArrayList<GoFishCard> completedSets;
    
    /**
     * constructor
     * @param name 
     */
    public GoFishPlayer(String name) {
        super(name);
        hand = new CardHand(0);
        completedSets = new ArrayList<>();
    }
    
    /**
     * Adds the argument cards to the CardHand class property
     * @param cards 
     */
    public void addCardsToHand(ArrayList <GoFishCard> cards){
        hand.addCards(cards);
    }
    
    /**
     * clears the player's hand so that a new game can be played
     */
    public void clearHandAndSets() {
        completedSets = new ArrayList<>();
        hand = new CardHand(0);
    }

    /**
     * method for the player to "fish", which means getting a card from the top of the deck
     * @param pool
     * @return the card fished, in case it needs to be printed in the context the method was called.
     */
    public GoFishCard fish(DeckOfCards pool){
        GoFishCard card = pool.getCardOnTop();
        hand.addCard(card);
        return card;
    }
    
    /**
     * Prints in the console the players hand, displaying his name and all the cards by suit and value
     */
    public void showHand() {
        System.out.println("\n" + super.getPlayerID() + "'s hand:");
        for (GoFishCard card : hand.getCards()) {
            System.out.println(card.getValue().toString() + " OF " + card.getSuit().toString());
        }
    }
    
    /**
     * returns the number of cards in hand
     * @return 
     */
    public int getNumberOfCardsInHand() {
        return hand.getCards().size();
    }
    
    /**
     * 
     */
    @Override
    public void play() {
        System.out.println(super.getPlayerID() + "'s turn");
    }
    
    /**
     * 
     * @param v
     * @return 
     */
    public boolean checkHand(GoFishCard.value v) {
        int numberOfCards = 0;
        for (GoFishCard card : hand.getCards()) {
            if (card.getValue().equals(v)) {
                numberOfCards++;
            }
        }
        return numberOfCards == 4;
    }
    
    /**
     * loops through the player's hand and checks if it contains a complete set (4 cards of the same value)
     * if any sets are present, they are removed from the hand added to the "completedSets" class variable
     */
    public void countSets(){
        ArrayList<GoFishCard> cardsToAddToCompletedPile = new ArrayList<>();;
        GoFishCard card, card1;
        
        for (Iterator<GoFishCard> cards = hand.getCards().iterator(); cards.hasNext();) {
            int numberOfSimilars = 0;
            card = cards.next();
            for (Iterator<GoFishCard> cards1 = hand.getCards().iterator(); cards1.hasNext();) {
                card1 = cards1.next();
                if (card.getValue().equals(card1.getValue())) {
                    numberOfSimilars++;
                }
                if (numberOfSimilars == 4) {
                    if (!cardsToAddToCompletedPile.contains(card1))
                        cardsToAddToCompletedPile.add(card1);
                    if (!cardsToAddToCompletedPile.contains(card))
                        cardsToAddToCompletedPile.add(card);
                }
            }  
        }
        if (cardsToAddToCompletedPile.size() > 0) {
            for (Iterator<GoFishCard> iterator = cardsToAddToCompletedPile.iterator(); iterator.hasNext();){
                completedSets.add(hand.getCards().remove(hand.getCards().indexOf(iterator.next())));
            }
        }
    }
    
    /**
     * prints to the console all the completed sets the player has
     */
    public void printCompletedSets() {
        if (completedSets.size() > 0) {
            for (int i = 0; i < completedSets.size(); i = i + 4) {
                System.out.printf("\n%s has a full set of %s",  super.getPlayerID(),completedSets.get(i).getValue());
            }
        }
    }
    
    /**
     * 
     * @return the number of completed sets the player has
     */
    public int getSets() {
        countSets();
        return completedSets.size() / 4;
    }
    
    /**
     * 
     * @param value
     * @return an ArrayList containing all the cards the player had with the same value 
     */
    public ArrayList <GoFishCard> giveCards(GoFishCard.value value) {
        ArrayList <GoFishCard> cardsToGive = new ArrayList<>();
        GoFishCard card;
        ArrayList <GoFishCard> cardsToRemove = new ArrayList<>();
        
        //iterates all the hand and adds to cardsToRemove, an auxiliary array of the cards matched, so they can be removed later
        for (Iterator<GoFishCard> cards = hand.getCards().iterator(); cards.hasNext();) {
            card = cards.next();
            //System.out.println(card.getValue());
            if (card.getValue() == value) {
                cardsToRemove.add(card);
            }
        }
        
        //removes the cards from the hand and adds them to the cards to give
        for (Iterator<GoFishCard> iterator = cardsToRemove.iterator(); iterator.hasNext();){
            cardsToGive.add(hand.getCards().remove(hand.getCards().indexOf(iterator.next())));
        }
        
        return cardsToGive;
    }
    
}
