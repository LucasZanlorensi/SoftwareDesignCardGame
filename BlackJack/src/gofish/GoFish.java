/*
 *  Lucas Zanlorensi
 */
package gofish;

import gofish.GoFishCard.value;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class GoFish extends Game{
    
    DeckOfCards pool;
    GoFishPlayer computer;
    String playerGuess;
    
    
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
        
        Scanner input = new Scanner(System.in);
        
        computer.addCardsToHand(pool.getCards(7));
        player.addCardsToHand(pool.getCards(7));
        player.showHand();
        computer.showHand();
        System.out.println("break");
        
        do {
            
            do
            {
            
                System.out.println("Please fish for a card.");
                
                playerGuess = input.next().toUpperCase();
                
                for(GoFishCard.value v : GoFishCard.value.values())
                {
                
                    if(v != playerGuess)
                        
                
                }
            
            }while("".equals(playerGuess));
            
        }
        while (pool.getDeckSize() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
