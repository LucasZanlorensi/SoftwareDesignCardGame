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
    
    ArrayList<GoFishPlayer> players;
    DeckOfCards pool;
    
    
    public GoFish(String givenName) {
        super(givenName);
        pool = new DeckOfCards();
        pool.generateDeck();
    }
    
    @Override
    public void play() 
    {

        pool.shuffle();
        for (GoFishCard card : pool.getCards())
            System.out.println(card.getValue());
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
