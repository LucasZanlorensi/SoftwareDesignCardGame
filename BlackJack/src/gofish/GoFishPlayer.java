/*
 *  Lucas Zanlorensi
 */
package gofish;

/**
 *
 * @author lucas
 */
public class GoFishPlayer extends Player{

    private CardHand hand;
    
    public GoFishPlayer(String name) {
        super(name);
        hand = new CardHand(0);
    }

    @Override
    public void play() {
        System.out.println(super.getPlayerID() + "'s turn");
    }
    
}
