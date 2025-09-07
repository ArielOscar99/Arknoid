/**
 * @author: Ariel Oscar id: 209341684
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * Function constructs a new BallRemover.
     * @param game
     * @param remainingBalls
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.setGame(game);
        this.setRemainingBalls(remainingBalls);
    }

    /**
     * Function sets a game with a given game.
     * @param game
     */
    public void setGame(GameLevel game) {
        this.game = game;
    }

    /**
     * Function sets a Counter with a given Counter.
     * @param remainingBalls
     */
    public void setRemainingBalls(Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
    }

    /**
     * @return game.
     */
    public GameLevel getGame() {
        return game;
    }

    /**
     * @return remainingBalls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * Function removes balls that are hit from the game.
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}
