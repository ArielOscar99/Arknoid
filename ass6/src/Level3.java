import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ariel Oscar id: 209341684
 */
public class Level3 implements  LevelInformation {
    @Override
    public int numberOfBalls() {
        return 4;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(6, -6));
        velocityList.add(new Velocity(-6, -6));
        velocityList.add(new Velocity(7, -7));
        velocityList.add(new Velocity(-7, -7));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 12;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Pink 3";
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.PINK);
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
                GameLevel.WIDTH - 2 * GameLevel.BORDER_WIDTH, 30), Color.GRAY);
        blockList.add(bottomBorder);

        //Blocks
        int i, blockHeight = 30, blockWidth = 50, height = 120;
        Block block;
        for (i = 0; i < 12; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height), blockWidth,
                    blockHeight), Color.DARK_GRAY);
            blockList.add(block);
        }
        height = height + blockHeight;
        for (i = 0; i < 11; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height), blockWidth,
                    blockHeight), Color.RED);
            blockList.add(block);
        }
        height = height + blockHeight;
        for (i = 0; i < 10; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height), blockWidth,
                    blockHeight), Color.YELLOW);
            blockList.add(block);
        }
        height = height + blockHeight;
        for (i = 0; i < 9; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height),
                    blockWidth, blockHeight), Color.BLUE);
            blockList.add(block);
        }
        height = height + blockHeight;
        for (i = 0; i < 8; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height),
                    blockWidth, blockHeight), Color.MAGENTA);
            blockList.add(block);
        }
        height = height + blockHeight;
        for (i = 0; i < 7; i++) {
            block = new Block(new Rectangle(new Point(
                    GameLevel.WIDTH - GameLevel.BORDER_WIDTH - (i + 1) * blockWidth, height),
                    blockWidth, blockHeight), Color.GREEN);
            blockList.add(block);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
