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
        GoFishPlayer player = ((GoFishPlayer) super.getPlayers().get(0));
        pool.shuffle();
        
        computer.addCardsToHand(pool.getCards(7));
        player.addCardsToHand(pool.getCards(7));
        
        
        do {

            
            
        }
        while (pool.getDeckSize() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
