/*
 *  Derek Schunicke
 *  991295326
 *  SYST 17796 - Software Design Fundamentals 
 */
package gofish;

import gofish.GoFishCard.suit;
import gofish.GoFishCard.value;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author derek
 */
public class GoFishPlayerTest {
    
    public GoFishPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fish method, of class GoFishPlayer.
     */
    @Test
    public void testFishGood() 
    {
        
        System.out.println("fish");
        DeckOfCards pool = new DeckOfCards();
        pool.generateDeck();
        GoFishPlayer instance = new GoFishPlayer("Tester");
        GoFishCard result = instance.fish(pool);
        assertTrue(result instanceof GoFishCard);
        
    }
    
    /**
     * Test of fish method, of class GoFishPlayer.
     */
    @Test
    public void testFishBad() {
        System.out.println("fish");
        DeckOfCards pool = new DeckOfCards();
        pool.generateDeck();
        
        while(pool.getDeckSize() > 0)
        {
            pool.getCardOnTop();
        }
        
        GoFishPlayer instance = new GoFishPlayer("Tester");
        GoFishCard result = instance.fish(pool);
        assertNull(result);
        
    }

    /**
     * Test of fish method, of class GoFishPlayer.
     */
    @Test
    public void testFishBoundary() {
        System.out.println("fish");
        DeckOfCards pool = new DeckOfCards();
        pool.generateDeck();
        
        while(pool.getDeckSize() > 1)
        {
            pool.getCardOnTop();
        }
        
        GoFishPlayer instance = new GoFishPlayer("Tester");
        GoFishCard result = instance.fish(pool);
        assertTrue(result instanceof GoFishCard);
        
    }
    
    /**
     * Test of getNumberOfCardsInHand method, of class GoFishPlayer.
     */
    @Test
    public void testGetNumberOfCardsInHandGood() 
    {
        
        System.out.println("getNumberOfCardsInHand");
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        cards.add(new GoFishCard(suit.HEARTS,value.ACE));
        cards.add(new GoFishCard(suit.DIAMONDS,value.ACE));
        cards.add(new GoFishCard(suit.CLUBS,value.ACE));
        instance.addCardsToHand(cards);
        int result = instance.getNumberOfCardsInHand();
        assertEquals(4, result);
        
    }
    
    /**
     * Test of getNumberOfCardsInHand method, of class GoFishPlayer.
     */
    @Test
    public void testGetNumberOfCardsInHandBoundary() 
    {
        
        System.out.println("getNumberOfCardsInHand");
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        instance.addCardsToHand(cards);
        int result = instance.getNumberOfCardsInHand();
        assertEquals(1, result);
        
    }

    /**
     * Test of checkHand method, of class GoFishPlayer.
     */
    @Test
    public void testCheckHandGood() 
    {
        
        System.out.println("checkHand");
        GoFishCard.value v = value.ACE;
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        cards.add(new GoFishCard(suit.HEARTS,value.ACE));
        cards.add(new GoFishCard(suit.DIAMONDS,value.ACE));
        cards.add(new GoFishCard(suit.CLUBS,value.ACE));
        instance.addCardsToHand(cards);
        boolean result = instance.checkHand(v);
        assertEquals(true, result);
        
    }
    
    /**
     * Test of checkHand method, of class GoFishPlayer.
     */
    @Test
    public void testCheckHandBad() 
    {
        
        System.out.println("checkHand");
        GoFishCard.value v = value.ACE;
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        instance.addCardsToHand(cards);
        boolean result = instance.checkHand(v);
        assertEquals(false, result);
        
    }
    
    /**
     * Test of checkHand method, of class GoFishPlayer.
     */
    @Test
    public void testCheckHandBoundary() 
    {
        
        System.out.println("checkHand");
        GoFishCard.value v = value.ACE;
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        cards.add(new GoFishCard(suit.HEARTS,value.ACE));
        cards.add(new GoFishCard(suit.DIAMONDS,value.ACE));
        instance.addCardsToHand(cards);
        boolean result = instance.checkHand(v);
        assertEquals(false, result);
        
    }

    /**
     * Test of getSets method, of class GoFishPlayer.
     */
    @Test
    public void testGetSetsGood() 
    {
        
        System.out.println("getSets");
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        cards.add(new GoFishCard(suit.HEARTS,value.ACE));
        cards.add(new GoFishCard(suit.DIAMONDS,value.ACE));
        cards.add(new GoFishCard(suit.CLUBS,value.ACE));
        cards.add(new GoFishCard(suit.SPADES,value.KING));
        cards.add(new GoFishCard(suit.HEARTS,value.KING));
        cards.add(new GoFishCard(suit.DIAMONDS,value.KING));
        cards.add(new GoFishCard(suit.CLUBS,value.KING));
        instance.addCardsToHand(cards);
        int result = instance.getSets();
        assertEquals(2, result);
        
    }
    
    /**
     * Test of getSets method, of class GoFishPlayer.
     */
    @Test
    public void testGetSetsBoundary() 
    {
        
        System.out.println("getSets");
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        instance.addCardsToHand(cards);
        int result = instance.getSets();
        assertEquals(0, result);
        
    }

    /**
     * Test of giveCards method, of class GoFishPlayer.
     */
    @Test
    public void testGiveCardsGood() {
        System.out.println("giveCards");
        GoFishCard.value v = value.ACE;
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> result = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        cards.add(new GoFishCard(suit.HEARTS,value.ACE));
        cards.add(new GoFishCard(suit.DIAMONDS,value.ACE));
        result.add(new GoFishCard(suit.CLUBS, value.ACE));
        
        instance.addCardsToHand(cards);
        
        result.addAll(instance.giveCards(v));
        assertEquals(4, result.size());
        
    }
    
    /**
     * Test of giveCards method, of class GoFishPlayer.
     */
    @Test
    public void testGiveCardsBoundary() {
        System.out.println("giveCards");
        GoFishCard.value v = value.ACE;
        GoFishPlayer instance = new GoFishPlayer("Tester");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> result = new ArrayList<>();
        cards.add(new GoFishCard(suit.SPADES,value.ACE));
        
        instance.addCardsToHand(cards);
        
        result.addAll(instance.giveCards(v));
        assertEquals(1, result.size());
        
    }
    
}
