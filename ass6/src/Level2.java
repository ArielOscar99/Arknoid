import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ariel Oscar id: 209341684
 */
public class Level2 implements  LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0, -4));
        velocityList.add(new Velocity(4, -5));
        velocityList.add(new Velocity(-3, 5));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 250;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.BLACK);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Block leftBorder = new Block(new Rectangle(new Point(0, 20), GameLevel.BORDER_WIDTH, GameLevel.HEIGHT),
                Color.GRAY);
        blockList.add(leftBorder);
        Block rightBorder = new Block(new Rectangle(new Point(GameLevel.WIDTH - GameLevel.BORDER_WIDTH, 20),
                GameLevel.BORDER_WIDTH, GameLevel.HEIGHT), Color.GRAY);
        blockList.add(rightBorder);
        Block topBorder = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH, 20),
                GameLevel.WIDTH - GameLevel.BORDER_WIDTH, GameLevel.BORDER_WIDTH), Color.GRAY);
        blockList.add(topBorder);
        Block bottomBorder = new Block(new Rectangle(new Point(0, GameLevel.HEIGHT),
                GameLevel.WIDTH, 30), Color.GRAY);
        blockList.add(bottomBorder);
        //Collidable blocks
        int blockwidth = 49, blockHeight = 30;
        Block temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH, 300), blockwidth, blockHeight),
                Color.RED);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + blockwidth, 300), blockwidth,
                blockHeight), Color.RED);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 2 * blockwidth, 300), blockwidth,
                blockHeight), Color.ORANGE);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 3 * blockwidth, 300), blockwidth,
                blockHeight), Color.ORANGE);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 4 * blockwidth, 300), blockwidth,
                blockHeight), Color.YELLOW);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 5 * blockwidth, 300), blockwidth,
                blockHeight), Color.YELLOW);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 6 * blockwidth, 300), blockwidth,
                blockHeight), Color.GREEN);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 7 * blockwidth, 300),
                blockwidth + 5, blockHeight), Color.GREEN);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 8 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.GREEN);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 9 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.BLUE);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 10 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.BLUE);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 11 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.PINK);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 12 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.PINK);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 13 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.CYAN);
        blockList.add(temp);
        temp = new Block(new Rectangle(new Point(GameLevel.BORDER_WIDTH + 14 * blockwidth + 5, 300),
                blockwidth, blockHeight), Color.CYAN);
        blockList.add(temp);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
