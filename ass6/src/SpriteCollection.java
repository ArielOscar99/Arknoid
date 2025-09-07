import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ariel Oscar id: 209341684
 */
public class SpriteCollection {
    private List<Sprite> spritesList;
    /**
     * Function constructs a new List of sprites.
     */
    public SpriteCollection() {
        this.spritesList = new ArrayList<>();
    }
    /**
     * Function adds a sprite to the sprites list.
     * @param s
     */
    public void addSprite(Sprite s) {
        if (s != null) {
            this.spritesList.add(s);
        }
    }

    /**
     * Function removes the given sprite from the sprites list.
     * @param s
     */
    public void removeSprite(Sprite s) {
        if (this.spritesList.contains(s)) {
            this.spritesList.remove(s);
        }
    }
    /**
     * Function returns the sprites list.
     * @return sprites.
     */
    public List<Sprite> getSprites() {
        return spritesList;
    }
    /**
     * Function calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spritesList.size(); i++) {
            spritesList.get(i).timePassed();
        }
    }
    /**
     * Function calls drawOn(d) on all sprites.
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spritesList.size(); i++) {
            spritesList.get(i).drawOn(d);
        }
    }
}