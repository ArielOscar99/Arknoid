import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class GameLevel implements Animation {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int BORDER_WIDTH = 30;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter counterScore;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;


    /**
     * Function initializes a new GameLevel.
     * @param level
     * @param keyboard
     * @param ar
     * @param counterScore
     */
    public GameLevel(LevelInformation level, biuoop.KeyboardSensor keyboard, AnimationRunner ar, Counter counterScore) {
        this.setLevel(level);
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.counterBlocks = new Counter();
        this.counterBalls = new Counter();
        this.setCounterScore(counterScore);
        this.setKeyboard(keyboard);
        this.setAnimationRunner(ar);
    }

    /**
     * @return sprites.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }
    /**
     * Function sets sprites.
     * @param sprites
     */
    public void setSprites(SpriteCollection sprites) {
        this.sprites = sprites;
    }
    /**
     * Function sets level.
     * @param level
     */
    public void setLevel(LevelInformation level) {
        this.level = level;
    }

    /**
     * Function sets counterScore.
     * @param counterScore
     */
    public void setCounterScore(Counter counterScore) {
        this.counterScore = counterScore;
    }

    /**
     * Function sets ar.
     * @param ar
     */


    public void setAnimationRunner(AnimationRunner ar) {
        this.runner = ar;
    }
    /**
     * Function sets keyboard.
     * @param keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * Function sets environment.
     * @param environment
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * @return environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }
    /**
     * @return HEIGHT.
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * @return counterBlocks.
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * @return counterBalls.
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * @return counterScore.
     */
    public Counter getCounterScore() {
        return counterScore;
    }

    /**
     * Function adds a new Collidable object to the GameEnvironment.
     * @param c
     */
    public void addCollidable(Collidable c) {
        if (c != null) {
            this.environment.addCollidable(c);
        }
    }

    /**
     * Function removes a Collidable object from the GameEnvironment.
     * @param c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * Function adds a new Sprite object to the SpriteCollection.
     * @param s
     */
    public void addSprite(Sprite s) {
        if (s != null) {
            this.sprites.addSprite(s);
        }
    }
    /**
     * Function removes a Sprite object from the SpriteCollection.
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * Function initialize a new game: creates all the sprites in the game (Blocks, Ball and Paddle). And add them to
     * the game.
     */
    public void initialize() {
        this.addSprite(this.level.getBackground());
        //Score
        ScoreTrackingListener ls = new ScoreTrackingListener(this.counterScore);
        ScoreIndicator indicator = new ScoreIndicator(ls);
        this.addSprite(indicator);
        //Blocks
        Block block;
        BlockRemover hl = new BlockRemover(this, this.counterBlocks);
        BallRemover hl2 = new BallRemover(this, this.counterBalls);
        for (int i = 0; i < this.level.blocks().size(); i++) {
            block = this.level.blocks().get(i);
            this.addSprite(block);
            this.addCollidable(block);
            if (i == 3) {
                block.addHitListener(hl2);
            }
            if (i > 3) {
                hl.getRemainingBlocks().increase(1);
                block.addHitListener(hl);
                block.addHitListener(ls);
            }
        }
        //Balls
        Ball temp;
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            temp = new Ball(new Point(400, 500), 5, Color.WHITE, environment);
            temp.setVelocity(this.level.initialBallVelocities().get(i));
            hl2.getRemainingBalls().increase(1);
            this.addSprite(temp);
        }
        //Paddle
        Paddle paddle = new Paddle(new Rectangle(new Point((this.WIDTH - this.level.paddleWidth()) / 2, 570),
                level.paddleWidth(), 20), 10, Color.WHITE, this.keyboard);
        paddle.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.initialize();
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        this.runner.run(this);
    }

    @Override
    /**
     * Function runs every step of the game.
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.setColor(Color.WHITE);
        d.drawText(500, 20, "Level Name: " + this.level.levelName(), 16);
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("P")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        } //Checks whether to pause the screen.
        if (this.counterBlocks.getCounter() == 0) {
            this.counterScore.increase(100);
            this.running = false;
        }
        if (this.counterBalls.getCounter() == 0) {
            this.running = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}