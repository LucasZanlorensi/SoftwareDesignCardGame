/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class GoFishPlayer extends Player{

    private CardHand hand;
    
    public GoFishPlayer(String name) {
        super(name);
        hand = new CardHand(0);
    }
    
    public void addCardsToHand(ArrayList <GoFishCard> cards){
        hand.addCards(cards);
    }

    public void fish(DeckOfCards pool){
        hand.addCard(pool.getCardOnTop());
    }
    
    @Override
    public void play() {
        System.out.println(super.getPlayerID() + "'s turn");
    }
    
}
