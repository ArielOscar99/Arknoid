import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;


    /**
     * AnimationRunner constructor with given GUI and sleeper.
     * @param gui
     */
    public AnimationRunner(GUI gui) {
        this.setGui(gui);
        this.setFramesPerSecond(60);
        this.sleeper = new Sleeper();
    }

    /**
     * @return gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * @return framesPerSecond
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * @return sleeper
     */
    public Sleeper getSleeper() {
        return sleeper;
    }

    /**
     * Function sets gui with a given GUI.
     * @param gui
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }

    /**
     * Function sets framesPerSecond with a given framesPerSecond.
     * @param framesPerSecond
     */
    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * Function sets sleeper with a given Sleeper.
     * @param sleeper
     */
    public void setSleeper(Sleeper sleeper) {
        this.sleeper = sleeper;
    }

    /**
     *
     * @param animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 35;

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
