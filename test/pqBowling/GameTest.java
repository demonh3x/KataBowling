package pqBowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAW
 */
public class GameTest {
    private Game instance;

    @Before
    public void setUp() {
        instance = new Game();
    }

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
        rollStrike();
        for (int i = 0; i < 9; i++){
            rollNoBonus();
        }
        assertEquals(10+5+4+(9*9), instance.getScore());
    }

    @Test
    public void multipleBonus() {
        rollStrike();
        rollStrike();
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
            rollStrike();
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

    private void rollStrike() {
        instance.roll(10);
    }
}