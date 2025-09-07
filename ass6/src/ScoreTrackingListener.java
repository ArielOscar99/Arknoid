/**
 * @author: Ariel Oscar id: 209341684
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Function constructs a new ScoreTrackingListener.
     * @param currentScore
     */
    public ScoreTrackingListener(Counter currentScore) {
        this.setCurrentScore(currentScore);
    }

    /**
     * Function sets a Counter with a given Counter.
     * @param currentScore
     */
    public void setCurrentScore(Counter currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * @return currentScore
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * Function adds points to the score.
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}