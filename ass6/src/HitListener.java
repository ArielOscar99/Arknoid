/**
 * @author: Ariel Oscar id: 209341684
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit. The hitter parameter is the Ball that's doing the
     * hitting.
     * @param beingHit
     * @param hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}