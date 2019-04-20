/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class CardHand extends GroupOfCards{
    
    private ArrayList <GoFishCard> cards;
    
    /**
     * Constructor
     * @param size 
     */
    CardHand(){
        super();
        cards = new ArrayList<>();
    }
        
    /**
     * @return the cards in the hand
     */
    public ArrayList <GoFishCard> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to add to the hand
     */
    public void addCards(ArrayList <GoFishCard> cards) {
        this.cards.addAll(cards);
    }
    
    /**
     * 
     * @param card
     * @return the card object removed from the hand
     */
    public GoFishCard removeCard(GoFishCard card) {
        return cards.remove(cards.indexOf(card));
    }
    
    /**
     * Adds the GoFishCard object to the array of cards called "cards"
     * @param card 
     */
    public void addCard(GoFishCard card){
        cards.add(card);
    }
    

    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "";
    }
}
