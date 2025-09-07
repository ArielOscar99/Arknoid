import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author Ariel Oscar id: 209341684
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;

    /**
     * GameFlow Constructor with given AnimationRunner and KeyboardSensor.
     * @param ar
     * @param ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.setAnimationRunner(ar);
        this.setKeyboardSensor(ks);

    }

    /**
     * Function sets a animationRunner.
     * @param animationRunner
     */
    public void setAnimationRunner(AnimationRunner animationRunner) {
        this.animationRunner = animationRunner;
    }

    /**
     * Function sets a animationRunner.
     * @param keyboardSensor
     */
    public void setKeyboardSensor(KeyboardSensor keyboardSensor) {
        this.keyboardSensor = keyboardSensor;
    }

    /**
     *
     * @param levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter counterScore = new Counter();
        Boolean flagWin = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, counterScore);
            level.run();
            if (level.getCounterBalls().getCounter() == 0) {
                flagWin = false;
                break;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new GameOverAnimation(flagWin, counterScore.getCounter())));
        this.animationRunner.getGui().close();
    }
}