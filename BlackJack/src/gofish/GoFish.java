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
public class GoFish 
{
    
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in);
        
        String playAgain;
        int players;
        
        
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
            
                do{
                    
                    System.out.println("How many players would you like to play with? (min 2, max 4):");

                    players = input.nextInt();
                    
                    if(players < 2 || players > 4)
                        System.out.println("Please enter a number of players from 2-4!");
                
                }while(players < 2 || players > 4);
                
            }
                
        
        }while(playAgain.equals("Y") && !playAgain.equals("N"));
        
    }
    
}
