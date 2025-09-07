import biuoop.DrawSurface;

/**
 * @author Ariel Oscar id: 209341684
 */
public class PauseScreen implements Animation {

    @Override
    /**
     * Function draws pause screen.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}