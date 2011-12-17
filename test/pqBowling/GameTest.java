/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqBowling;

import pqBowling.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAW
 */
public class GameTest {
    private Game instance;
    
    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        instance = new Game();
    }
    
    @After
    public void tearDown() {
    }

    //TESTS----------------------------------------------------------
    @Test
    public void gutterGame() {
        for(int i = 0; i < 20; i++){
            instance.roll(0);
        }
        assertEquals(0, instance.getScore());
    }

    @Test
    public void noBonusGame() {
        for (int i = 0; i < 10; i++){
            instance.roll(9);
            instance.roll(0);
        }
        assertEquals(90, instance.getScore());
    }
    
    @Test
    public void oneSpare() {
        rollSpare();
        for (int i = 0; i < 9; i++){
            rollNoBonus();
        }
        assertEquals(5+5+5+(9*9), instance.getScore());
    }
    
    @Test
    public void oneStrike() {
        instance.roll(10);
        for (int i = 0; i < 9; i++){
            rollNoBonus();
        }
        assertEquals(10+5+4+(9*9), instance.getScore());
    }

    @Test
    public void multipleBonus() {
        instance.roll(10);
        instance.roll(10);
        rollSpare();
        rollSpare();
        for (int i = 0; i < 6; i++){
            rollNoBonus();
        }
        assertEquals((10+10+5)+(10+5+5)+(5+5+5)+(5+5+5)+(9*6), instance.getScore());
    }
    
    @Test
    public void allSpares() {
        for (int i = 0; i < 10; i++) {
            rollSpare();
        }
        instance.roll(5);
        assertEquals((5+5+5)*10, instance.getScore());
    }

    @Test
    public void perfectGame() {
        for (int i = 0; i < 12; i++) {
            instance.roll(10);
        }
        assertEquals((30)*10, instance.getScore());
    }

    private void rollNoBonus() {
        instance.roll(5);
        instance.roll(4);
    }

    private void rollSpare() {
        instance.roll(5);
        instance.roll(5);
    }

}
