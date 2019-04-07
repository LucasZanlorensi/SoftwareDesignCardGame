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
    private ArrayList <GoFishCard> cards;
    
    public void generateHand()
        {
                int countCards = 0;
		for(GoFishCard.suit s: GoFishCard.suit.values())
                {
                    for(GoFishCard.value v: GoFishCard.value.values())
                    {
                        cards.set(countCards, new GoFishCard(s,v));
                        countCards++;
                    }
                }
        }
    
    public GoFish(String givenName) {
        super(givenName);
    }
    

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
