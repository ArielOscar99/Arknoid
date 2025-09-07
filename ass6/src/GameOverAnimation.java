import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class GameOverAnimation implements Animation {
    private boolean win;
    private int finalScore;

    /**
     * GameOverAnimation constructor with a given boolean win and final Score.
     * @param win
     * @param finalScore
     */
    public GameOverAnimation(boolean win, int finalScore) {
        this.setWin(win);
        this.setFinalScore(finalScore);
    }

    /**
     * Function sets win with a given boolean.
     * @param win
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Function sets finalScore with a given int.
     * @param finalScore
     */
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, GameLevel.WIDTH, GameLevel.HEIGHT);
        d.setColor(Color.WHITE);
        d.drawText(280, d.getHeight() / 2 - 40, "Game Over", 50);
        if (this.win) {
            d.drawText(260, d.getHeight() / 2 + 40, "You Win! Your score is " + this.finalScore, 25);
        } else {
            d.drawText(300, d.getHeight() / 2 + 40, "Your score is " + this.finalScore, 25);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
