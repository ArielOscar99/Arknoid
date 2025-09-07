import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ariel Oscar id: 209341684
 */
public class Ass6Game {
    /**
     * Final game of ass3.
     * @param args
     */
    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        Level4 level4 = new Level4();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levels.add(level1);
            }
            if (args[i].equals("2")) {
                levels.add(level2);
            }
            if (args[i].equals("3")) {
                levels.add(level3);
            }
            if (args[i].equals("4")) {
                levels.add(level4);
            }
        }

        if (levels.isEmpty()) {
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);
        }

        GUI gui = new GUI("Arcanoid", GameLevel.WIDTH, GameLevel.HEIGHT);
        AnimationRunner ar = new AnimationRunner(gui);
        KeyboardSensor keyboard = ar.getGui().getKeyboardSensor();
        GameFlow game = new GameFlow(ar, keyboard);
        game.runLevels(levels);
    }
}
