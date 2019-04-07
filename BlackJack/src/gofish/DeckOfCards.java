/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class DeckOfCards extends GroupOfCards{

    
    private static ArrayList <GoFishCard> cards;
    
    public static void generateDeck() 
    {

        cards = new ArrayList<>();

        for (GoFishCard.suit s : GoFishCard.suit.values()) {
            for (GoFishCard.value v : GoFishCard.value.values()) {

                cards.add(new GoFishCard(s, v));
                System.out.println("Suit: " + s + " Value: " + v);

            }

        }

        System.out.println(cards.size());

    }
    
    public DeckOfCards(int size) {
        super(size);
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
