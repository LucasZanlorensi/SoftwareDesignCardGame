/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

/**
 *
 * @author lucas
 */
public class GoFishCard extends Card{

    public enum value{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
    public enum suit {HEARTS, SPADES, CLUBS, DIAMONDS};
    private value value;
    private suit suit;
    
    /**
     * 
     * @param c
     * @param v 
     */
    public GoFishCard(suit c, value v) {
        this.suit = c;
        this.value = v;
    }
    
    /**
     * 
     * @return the suit of the card
     */
    public suit getSuit(){
        return suit;
    }
    
    /**
     * Sets the card's suit
     * @param suit 
     */
    public void setSuit(suit suit){
        this.suit = suit;
    }
    
    /**
     * @return the card's value
     */
    public value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(value value) {
        this.value = value;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Suit:" + this.suit + " Value: " + this.value;
    }

}
