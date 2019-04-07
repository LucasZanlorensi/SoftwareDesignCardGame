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
    
    CardHand(int size){
        super(size);
        cards = new ArrayList<>();
    }
        
    /**
     * @return the cards
     */
    public ArrayList <GoFishCard> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void addCards(ArrayList <GoFishCard> cards) {
        this.cards.addAll(cards);
    }
    
    public void removeCard(GoFishCard card) {
        this.cards.remove(card);
    }
    
    public void addCard(GoFishCard card){
        cards.add(card);
    }
    
    // TODO
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "";
    }
}
