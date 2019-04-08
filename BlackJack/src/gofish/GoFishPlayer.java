/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class GoFishPlayer extends Player{

    private CardHand hand;
    private ArrayList<GoFishCard> completedSets;
    private int sets;
    
    public GoFishPlayer(String name) {
        super(name);
        hand = new CardHand(0);
        completedSets = new ArrayList<>();
        sets = 0;
    }
    
    public void addCardsToHand(ArrayList <GoFishCard> cards){
        hand.addCards(cards);
    }

    public void fish(DeckOfCards pool){
        hand.addCard(pool.getCardOnTop());
    }
    
    public void showHand() {
        System.out.println("\n" + super.getPlayerID() + "'s hand:");
        for (GoFishCard card : hand.getCards()) {
            System.out.println(card.getValue().toString() + " OF " + card.getSuit().toString());
        }
    }
    
    @Override
    public void play() {
        System.out.println(super.getPlayerID() + "'s turn");
    }
    
    public boolean checkHand(GoFishCard.value v) {
        int numberOfCards = 0;
        for (GoFishCard card : hand.getCards()) {
            if (card.getValue().equals(v)) {
                numberOfCards++;
            }
        }
        return numberOfCards == 4;
    }
    
    public void countSets(){
        sets = 0;
        for (GoFishCard card : hand.getCards()) {
            
            //if the hand has a complete set, increase the counter and add it 
            //to the completedSet pile
            if (checkHand(card.getValue())) {
                completedSets.addAll(giveCards(card.getValue()));
                sets++;
            }
        }
    }
    
    public int getSets() {
        countSets();
        return this.sets;
    }
    
    public ArrayList <GoFishCard> giveCards(GoFishCard.value value) {
        ArrayList <GoFishCard> cardsToGive = new ArrayList<>();
        GoFishCard card = null;
        ArrayList <GoFishCard> cardsToRemove = new ArrayList<>();
        
        //iterates all the hand and adds to cardsToRemove, an auxiliary array of the cards matched, so they can be removed later
        for (Iterator<GoFishCard> cards = hand.getCards().iterator(); cards.hasNext();) {
            card = cards.next();
            //System.out.println(card.getValue());
            if (card.getValue() == value) {
                cardsToRemove.add(card);
            }
        }
        
        //removes the cards
        for (Iterator<GoFishCard> iterator = cardsToRemove.iterator(); iterator.hasNext();){
            cardsToGive.add(hand.getCards().remove(hand.getCards().indexOf(iterator.next())));
        }
        
        return cardsToGive;
    }
    
}
