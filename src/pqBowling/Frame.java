package pqBowling;

/**
 * @author Mateu Adsuara Sabater
 */
public class Frame {
    private static final int MAX_FRAMES = 9;
    private int shots = 0;
    private int pins[] = {0, 0, 0};
    private int frameNumber = 0;

    public boolean isStrike() {
        return (shots == 1 && pins[0] == 10);
    }

    public boolean isSpare() {
        return (shots == 2 && (pins[0] + pins[1]) == 10);
    }

    public boolean ended() {
        return
        (frameNumber < MAX_FRAMES) && (
                isStrike() || shots == 2
        ) ||
        (frameNumber == MAX_FRAMES) && (
                ((isSpare() || isStrike()) && shots == 3) ||
                ((!isSpare() && !isStrike()) && shots == 2)
        );
    }

    public void shoot(int droppedPins) {
        if (ended())
            throw new IllegalStateException("Shooting on a finished frame");
        pins[shots++] = droppedPins;
    }

    public int getScore(){
        return pins[0] + pins[1] + pins[2];
    }

    public void nextFrame(){
        shots = 0;
        for (int i = 0; i < pins.length; i++) {
            pins[i] = 0;
        }
        frameNumber++;
    }
}

