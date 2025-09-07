/**
 * @author Ariel Oscar id: 209341684
 * A BlockRemover is in charge of removing blocks from the game, as well as keeping count of the number of blocks that
 * remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Function constructs a new BlockRemover.
     * @param game
     * @param removedBlocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.setGame(game);
        this.setRemainingBlocks(removedBlocks);
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
     * @param remainingBlocks
     */
    public void setRemainingBlocks(Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * @return game.
     */
    public GameLevel getGame() {
        return this.game;
    }

    /**
     * @return remainingBlocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
    /**
     * Function removes Blocks that are hit from the game.
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
    }
}