import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ariel Oscar id: 209341684
 */
public class Level1 implements  LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0, -2));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
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
                GameLevel.WIDTH - 2 * GameLevel.BORDER_WIDTH, 30), Color.GRAY);
        blockList.add(bottomBorder);
        //Collidable blocks
        Block temp = new Block(new Rectangle(new Point(385, 150), 30, 30), Color.RED);
        blockList.add(temp);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
