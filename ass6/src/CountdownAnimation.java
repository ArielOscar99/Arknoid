import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class CountdownAnimation implements Animation {
    private boolean stop;
    private double numOfSeconds;
    private int countFrom;
    private long millSeconds;
    private long startMillSeconds;
    private SpriteCollection gameScreen;

    /**
     * CountdownAnimation Constructor with given numOfSeconds, countFrom and SpriteCollection.
     * @param numOfSeconds
     * @param countFrom
     * @param gameScreen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.setNumOfSeconds(numOfSeconds);
        this.setCountFrom(countFrom);
        this.setGameScreen(gameScreen);
        this.millSeconds = (long) (this.numOfSeconds * 1000 / this.countFrom);
        this.startMillSeconds = System.currentTimeMillis(); // timing
        this.stop = false;

    }

    /**
     * Function sets numOfSeconds.
     * @param numOfSeconds
     */
    public void setNumOfSeconds(double numOfSeconds) {
        this.numOfSeconds = numOfSeconds;
    }

    /**
     * Function sets countFrom.
     * @param countFrom
     */
    public void setCountFrom(int countFrom) {
        this.countFrom = countFrom;
    }

    /**
     * Function sets gameScreen.
     * @param gameScreen
     */
    public void setGameScreen(SpriteCollection gameScreen) {
        this.gameScreen = gameScreen;
    }

    /**
     * Function sets startMillSeconds.
     * @param startMillSeconds
     */
    public void setStartMillSeconds(long startMillSeconds) {
        this.startMillSeconds = startMillSeconds;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);

        d.setColor(Color.WHITE);
        d.drawText(400, 350, "" + this.countFrom, 40);
        if (this.countFrom < 0) {
            this.stop = true;
        }
        long time = System.currentTimeMillis();
        if (time - this.startMillSeconds >= this.millSeconds) {
            this.setCountFrom(this.countFrom - 1);
            this.setStartMillSeconds(time);
        }
        if (this.countFrom < 0) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
