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
    
    
    public GoFish(String givenName) {
        super(givenName);
        pool = new DeckOfCards();
        pool.generateDeck();
    }
    
    @Override
    public void play() {
        pool.shuffle();
        
        do {

            ((GoFishPlayer) super.getPlayers().get(0)).play();
            
        }
        while (pool.getCards().size() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
