/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;
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
        GoFishPlayer player = null;
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
                if (player == null){
                    String playerName = input.next();
                    player = new GoFishPlayer(playerName);        
                }
                if (game == null) {
                    game = new GoFish("GoFish");
                }
            }
        }while(playAgain.equals("Y") && !playAgain.equals("N"));
    }
}
