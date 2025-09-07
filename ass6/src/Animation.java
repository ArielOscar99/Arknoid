import biuoop.DrawSurface;

/**
 * @author Ariel Oscar id: 209341684
 */
public interface Animation {
    /**
     * Function draws the sprites and collidables and checks whether the game should end.
     * @param d
     */
    void doOneFrame(DrawSurface d);

    /**
     *
     * @return true or false whether the game ends
     */
    boolean shouldStop();
}
