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
    public void testGetCardsGood() 
    {
        
        System.out.println("getCardsGood");
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
    public void testGetCardsBad() 
    {
        
        System.out.println("getCardsBad");
        int numberOfCards = 7;
        DeckOfCards instance = new DeckOfCards();
        instance.setCards(new ArrayList<>());
        ArrayList<GoFishCard> result = instance.getCards(numberOfCards);
        assertEquals(0, result.size());
        
    }

    /**
     * Test of getCardOnTop method, of class DeckOfCards.
     */
    @Test
    public void testGetCardOnTopGood() 
    {
        
        System.out.println("getCardOnTopGood");
        DeckOfCards instance = new DeckOfCards();
        instance.generateDeck();
        GoFishCard result = instance.getCardOnTop();
        assertTrue(result instanceof GoFishCard);
        
    }
    
    /**
     * Test of getCardOnTop method, of class DeckOfCards.
     */
    @Test
    public void testGetCardOnTopBad() 
    {
        
        System.out.println("getCardOnTopBad");
        DeckOfCards instance = new DeckOfCards();
        instance.setCards(new ArrayList<>());
        GoFishCard result = instance.getCardOnTop();
        assertFalse(result instanceof GoFishCard);
        
    }

    /**
     * Test of getDeckSize method, of class DeckOfCards.
     */
    @Test
    public void testGetDeckSizeGood() 
    {
        
        System.out.println("getDeckSizeGood");
        DeckOfCards instance = new DeckOfCards();
        instance.generateDeck();
        int result = instance.getDeckSize();
        assertEquals(52, result);
        
    }
    
    /**
     * Test of getDeckSize method, of class DeckOfCards.
     */
    @Test
    public void testGetDeckSizeBoundary() 
    {
        
        System.out.println("getDeckSizeBoundary");
        DeckOfCards instance = new DeckOfCards();
        instance.setCards(new ArrayList<>());
        int result = instance.getDeckSize();
        assertEquals(0, result);
        
    }
    
}
