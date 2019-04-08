/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lucas
 */
public class DeckOfCards extends GroupOfCards{

    
    private ArrayList <GoFishCard> cards;
    
    public void generateDeck() 
    {

        cards = new ArrayList<>();

        for (GoFishCard.value v : GoFishCard.value.values()) 
        {
            
            for (GoFishCard.suit s : GoFishCard.suit.values()) 
            {
                
                cards.add(new GoFishCard(s, v));
            
            }

        }

        //System.out.println(cards.size());

    }
    
    
    public DeckOfCards() {
        super(0);
    }
    /**
     * @return the cards
     */
    public ArrayList <GoFishCard> getCards(int numberOfCards) {
        ArrayList cardsRemoved = new ArrayList();
        for (int i = 0; i < numberOfCards; i++) {
            cardsRemoved.add(cards.remove(0));
        }
        return cardsRemoved;
    }

    public GoFishCard getCardOnTop() {
        return cards.remove(0);
    }
    
    public int getDeckSize() {
        return this.cards.size();
    }
    
    @Override
    public void shuffle(){
        Collections.shuffle(cards);
    }
    
    /**
     * @param cards the cards to set
     */
    public void setCards(ArrayList <GoFishCard> cards) {
        this.cards = cards;
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
