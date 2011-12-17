package pqBowling;

/**
 * @author Mateu Adsuara Sabater
 */
public class Frame {
    private int shots = 0;
    private int pins[] = {0, 0};
    protected int frameNumber = 0;

    public boolean isStrike(){
        return (shots == 1 && pins[0] == 10);
    }

    public boolean isSpare(){
        return (shots == 2 && (pins[0] + pins[1]) == 10);
    }

    public boolean noBonus(){
        return (!isStrike() && !isSpare());
    }

    public boolean ended(){
        return (isStrike() || shots == 2);
    }

    public boolean shoot(int droppedPins){
        if (!ended()){
            pins[shots] = droppedPins;
            shots++;
            return true;
        } else {
            return false;
        }
    }

    public int getScore(){
        return pins[0] + pins[1];
    }

    public void reset(){
        shots = 0;
        pins[0] = 0;
        pins[1] = 0;
        frameNumber++;
    }
}

