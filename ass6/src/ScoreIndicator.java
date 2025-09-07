import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author: Ariel Oscar id: 209341684
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener listener;

    /**
     * Function constructs a new ScoreIndicator.
     * @param listener
     */
    public ScoreIndicator(ScoreTrackingListener listener) {
        this.listener = listener;
    }

    /**
     * Function draws score on the screen.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(350, 20, "Score: " + this.listener.getCurrentScore().getCounter(), 16);
    }

    /**
     */
    @Override
    public void timePassed() {

    }
}
