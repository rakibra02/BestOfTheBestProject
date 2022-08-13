/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uno.ActionCard;
import uno.NumberCard;

/**
 *
 * @author ranoo
 */
public class PlayerTest {

    public PlayerTest() {
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
     * Test of checkMove method, of class Player.
     */
    @Test
    public void testCheckMoveGood() {
        System.out.println("checkMove good");
        Card playerCard = new ActionCard("blue", "reverse");
        Card currentCard = new NumberCard("blue", 3);
        Player instance = new Player("Player");
        boolean expResult = true;
        boolean result = instance.checkMove(playerCard, currentCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkMove method, of class Player.
     */
    @Test
    public void testCheckMoveBad() {
        System.out.println("checkMove bad");
        Card playerCard = new ActionCard("blue", "reverse");
        Card currentCard = new NumberCard("yellow", 4);
        Player instance = new Player("Player");
        boolean expResult = false;
        boolean result = instance.checkMove(playerCard, currentCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkMove method, of class Player.
     */
    @Test
    public void testCheckMoveBoundry() {
        System.out.println("checkMove boundry");
        Card playerCard = new NumberCard("blue", 2);
        Card currentCard = new NumberCard("yellow", 2);
        Player instance = new Player("Player");
        boolean expResult = true;
        boolean result = instance.checkMove(playerCard, currentCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
