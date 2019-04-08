/*
 *  Lucas Zanlorensi
 */
package gofish;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class GoFishPlayer extends Player{

    private CardHand hand;
    private int sets;
    
    public GoFishPlayer(String name) {
        super(name);
        hand = new CardHand(0);
        sets = 0;
    }
    
    public void addCardsToHand(ArrayList <GoFishCard> cards){
        hand.addCards(cards);
    }

    public void fish(DeckOfCards pool){
        hand.addCard(pool.getCardOnTop());
    }
    
    public void showHand() {
        System.out.println(super.getPlayerID() + "'s hand:");
        for (GoFishCard card : hand.getCards()) {
            System.out.println(card.getValue().toString() + " OF " + card.getSuit().toString());
        }
        
        System.out.println("");
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
            if (checkHand(card.getValue())) {
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
        
        for (GoFishCard card : hand.getCards()) {
            System.out.println(card.getValue());
            if (card.getValue() == value) {
                cardsToGive.add(hand.removeCard(card));
            }
        }
        return cardsToGive;
    }
    
}
