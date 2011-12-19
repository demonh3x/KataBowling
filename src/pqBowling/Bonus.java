package pqBowling;

/**
 *
 * @author sortega
 */
public class Bonus {

    private int nextBonus = 0;
    private int afterNextBonus = 0;

    public int next() {
        int temp = nextBonus;
        nextBonus = afterNextBonus;
        afterNextBonus = 0;
        return temp;
    }

    public void strike() {
        nextBonus++;
        afterNextBonus++;
    }

    public void spare() {
        nextBonus++;
    }
}
