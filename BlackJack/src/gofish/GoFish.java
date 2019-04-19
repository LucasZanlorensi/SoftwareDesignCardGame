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
        boolean playerHadToFish, computerHadToFish;
        computer.addCardsToHand(pool.getCards(7));
        player.addCardsToHand(pool.getCards(7));
        
        
        
        GoFishCard.value userChoice = null, computerChoice = null;
        ArrayList <GoFishCard> cardsTakenFromComputer = new ArrayList<>();
        ArrayList <GoFishCard> cardsGivenTocomputer = new ArrayList<>();
        
        do {
            do {
                do {
                    playerHadToFish = false;
                    player.showHand();
                    computer.showHand();

                    System.out.print("\n" + player.getPlayerID() + " please ask computer for a card: ");

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
                        System.out.print("\nInvalid card. Please ask for another card: ");

                }while(!validGuess);

                cardsTakenFromComputer = computer.giveCards(userChoice);
                //checks if the computer had the card the user asked for
                //if yes, add the card(s) to the player's hand
                if(cardsTakenFromComputer.size() > 0) {
                    System.out.printf("\nNice! The computer had %d %s(S)", cardsTakenFromComputer.size(), userChoice.name());
                    player.addCardsToHand(cardsTakenFromComputer);
                }
                else {
                    System.out.printf("The computer does not have a %s, go fish!\n", userChoice.name());
                    System.out.printf("You got a %s\n", player.fish(pool).getValue());
                    playerHadToFish = true;
                }
                player.countSets();
                System.out.printf("\nYou have %d completed sets\n", player.getSets());
            } while (!playerHadToFish);
            
            do {
                //computer's turn
                computerHadToFish = false;

                int computerChoiceNumber = (int) (Math.random() * 13);
                switch (computerChoiceNumber) {
                    case 0:
                        computerChoice = GoFishCard.value.valueOf("TWO");
                        break;
                    case 1:
                        computerChoice = GoFishCard.value.valueOf("THREE");
                        break;
                    case 2:
                        computerChoice = GoFishCard.value.valueOf("FOUR");
                        break;
                    case 3:
                        computerChoice = GoFishCard.value.valueOf("FIVE");
                        break;
                    case 4:
                        computerChoice = GoFishCard.value.valueOf("SIX");
                        break;
                    case 5:
                        computerChoice = GoFishCard.value.valueOf("SEVEN");
                        break;
                    case 6:
                        computerChoice = GoFishCard.value.valueOf("EIGHT");
                        break;
                    case 7:
                        computerChoice = GoFishCard.value.valueOf("NINE");
                        break;
                    case 8:
                        computerChoice = GoFishCard.value.valueOf("TEN");
                        break;
                    case 9:
                        computerChoice = GoFishCard.value.valueOf("JACK");
                        break;
                    case 10:
                        computerChoice = GoFishCard.value.valueOf("QUEEN");
                        break;
                    case 11:
                        computerChoice = GoFishCard.value.valueOf("KING");
                        break;
                    case 12:
                        computerChoice = GoFishCard.value.valueOf("ACE");
                        break;
                }

                System.out.println("\nThe computer chose: " + computerChoice);
                cardsGivenTocomputer = player.giveCards(computerChoice);

                if (cardsGivenTocomputer.size() > 0) {
                    System.out.printf("\nThe computer took your %d %s(S)", cardsGivenTocomputer.size(), computerChoice.name());
                    computer.addCardsToHand(cardsGivenTocomputer);
                }
                else {
                    System.out.println("The computer went fishing!");
                    computer.fish(pool);
                    computerHadToFish = true;
                }
                computer.countSets();
            } while (!computerHadToFish);
        }
        while (pool.getDeckSize() > 0);
    }

    
    
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
