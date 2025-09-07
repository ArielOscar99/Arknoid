import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class Background implements Sprite {
    private java.awt.Color color;

    /**
     * Background constructor using a given color.
     * @param color
     */
    public Background(Color color) {
        this.setColor(color);
    }

    /**
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Function sets color with a given color.
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color); //drawing rectangle frames
        d.fillRectangle(0, 0, GameLevel.WIDTH, GameLevel.HEIGHT);
    }

    @Override
    public void timePassed() {

    }
}
