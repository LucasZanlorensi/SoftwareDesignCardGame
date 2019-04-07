/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class GoFish extends Game{
    
    DeckOfCards pool;
    GoFishPlayer computer;
    
    
    public GoFish(String givenName) {
        super(givenName);
        computer = new GoFishPlayer("Computer");
        pool = new DeckOfCards();
        pool.generateDeck();
    }
    
    @Override
    public void play() {
        
        pool.shuffle();
        
        computer.addCardsToHand(pool.getCards(7));
        ((GoFishPlayer) super.getPlayers().get(0)).addCardsToHand(pool.getCards(7));
        
        do {

            ((GoFishPlayer) super.getPlayers().get(0)).play();
            
        }
        while (pool.getDeckSize() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
