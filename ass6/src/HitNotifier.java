/**
 * @author: Ariel Oscar id: 209341684
 */
public interface HitNotifier {
    /**
     * Function adds hl as a listener to hit events
     * @param hl
     */
    void addHitListener(HitListener hl);
    /**
     * Function removes hl from the list of listeners to hit events.
     * @param hl
     */
    void removeHitListener(HitListener hl);
}