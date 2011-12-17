package pqBowling;

/**
 *
 * @author sortega
 */
public class Bonus {

    private int bonusN = 0;
    private int bonusNN = 0;

    public int next() {
        int nextBonus = bonusN;
        bonusN = bonusNN;
        bonusNN = 0;
        return nextBonus;
    }

    public void strike() {
        bonusN++;
        bonusNN++;
    }

    public void spare() {
        bonusN++;
    }
}
