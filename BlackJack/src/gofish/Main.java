/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Main
{
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        String playAgain = "";
        ArrayList<Player> players = null;
        GoFish game = null;
        
        do 
        {
            do{       
                System.out.println("Do you want to play Go Fish? (Y/N)");
        
                playAgain = input.next().toUpperCase();
                
                if(!playAgain.equals("Y") && !playAgain.equals("N"))
                    System.out.println("Please enter either 'Y' for yes or 'N' for no!");
            
            }while(!playAgain.equals("Y") && !playAgain.equals("N"));
            
            if(playAgain.equals("Y"))
            {
                if (players == null){
                    System.out.println("Please write your name");
                    String playerName = input.next();
                    players = new ArrayList<>();
                    players.add(new GoFishPlayer(playerName));
                    players.add(new GoFishPlayer("Computer"));
                }
                if (game == null) {
                    game = new GoFish("GoFish");
                }
                game.setPlayers(players);
                
                DeckOfCards.generateDeck();
                
               
            }
            
        }while(playAgain.equals("Y") && !playAgain.equals("N"));
    }
}
