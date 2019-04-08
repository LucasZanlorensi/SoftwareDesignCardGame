/*
 *  Lucas Zanlorensi
 */
package gofish;

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
    boolean validGuess;
    
    
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
        
        GoFishCard.value userChoice = null;
        ArrayList <GoFishCard> cardsTakenFromcomputer = new ArrayList<>();
        
        do {
            
            do
            {
            
                System.out.println(player.getPlayerID() + " please ask computer for a card.");
                
                playerGuess = input.next().toUpperCase();
                
                for(GoFishCard.value v : GoFishCard.value.values())
                {
                
                    if(v.toString().equals(playerGuess))
                    {
                    
                        validGuess = true;
                        userChoice = v.valueOf(playerGuess);
                        break;
                    
                    }
                    
                    else
                        validGuess = false;
                
                }
                
                if(!validGuess)
                    System.out.println("Invalid card. Please ask for another card.");
                            
            }while(!validGuess);
            
            
            cardsTakenFromcomputer = computer.giveCards(userChoice);
            //checks if the computer had the card the user asked for
            //if yes, add the card(s) to the player's hand
            if(cardsTakenFromcomputer.size() > 0) {
                player.addCardsToHand(cardsTakenFromcomputer);
            }
            else
                player.fish(pool);
            
            
        }
        while (pool.getDeckSize() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
