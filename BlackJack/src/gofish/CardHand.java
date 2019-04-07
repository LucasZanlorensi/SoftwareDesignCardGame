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
    
    public GoFishCard removeCard(GoFishCard card) {
        return cards.remove(cards.indexOf(card));
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
