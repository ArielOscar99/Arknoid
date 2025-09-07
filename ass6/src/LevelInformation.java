import java.util.List;

/**
 * @author Ariel Oscar id: 209341684
 */
public interface LevelInformation {
    /**
     * @return numberOfBalls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball. Note that initialBallVelocities().size() == numberOfBalls().
     * @return initialBallVelocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return paddleSpeed
     */
    int paddleSpeed();

    /**
     * @return paddleWidth
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     * @return levelName
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return getBackground
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return blocks list.
     */
    List<Block> blocks();
    // The number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * The number of blocks that should be removed.
     * @return numberOfBlocksToRemove
     */
    int numberOfBlocksToRemove();
}