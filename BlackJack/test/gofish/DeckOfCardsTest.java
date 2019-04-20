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
public class DeckOfCardsTest {
    
    public DeckOfCardsTest() {
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
     * Test of getCards method, of class DeckOfCards.
     */
    @Test
    public void testGetCardsGood() {
        System.out.println("getCards");
        int numberOfCards = 7;
        DeckOfCards instance = new DeckOfCards();
        instance.generateDeck();
        int expResult = 7;
        ArrayList<GoFishCard> result = instance.getCards(numberOfCards);
        assertEquals(expResult, result.size());
        
    }
    
    /**
     * Test of getCards method, of class DeckOfCards.
     */
    @Test
    public void testGetCardsBad() {
        System.out.println("getCards");
        int numberOfCards = 7;
        DeckOfCards instance = new DeckOfCards();
        int expResult = 0;
        ArrayList<GoFishCard> result = instance.getCards(numberOfCards);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getCardOnTop method, of class DeckOfCards.
     */
    @Test
    public void testGetCardOnTop() {
        System.out.println("getCardOnTop");
        DeckOfCards instance = new DeckOfCards();
        GoFishCard expResult = null;
        GoFishCard result = instance.getCardOnTop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeckSize method, of class DeckOfCards.
     */
    @Test
    public void testGetDeckSize() {
        System.out.println("getDeckSize");
        DeckOfCards instance = new DeckOfCards();
        int expResult = 0;
        int result = instance.getDeckSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class DeckOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        DeckOfCards instance = new DeckOfCards();
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCards method, of class DeckOfCards.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        ArrayList<GoFishCard> cards = null;
        DeckOfCards instance = new DeckOfCards();
        instance.setCards(cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DeckOfCards.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DeckOfCards instance = new DeckOfCards();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
