import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.*;

/**
 * @author Ariel Oscar id: 209341684
 */
public class Paddle implements Sprite, Collidable {
    public static final int WIDTH = 800;
    public static final int BORDER_WIDTH = 30;
    private final double epsilon = Math.pow(10, -10);
    private Rectangle paddle;
    private int speed;
    private java.awt.Color color;
    private biuoop.KeyboardSensor keyboard;

    /**
     * Constructor of Paddle.
     * @param paddle
     * @param speed
     * @param color
     * @param keyboard
     */
    public Paddle(Rectangle paddle, int speed, java.awt.Color color, biuoop.KeyboardSensor keyboard) {
        this.setPaddle(paddle);
        this.setSpeed(speed);
        this.setColor(color);
        this.setKeyboard(keyboard);
    }
    /**
     * Function sets a rectangle with the given paddle.
     * @param paddle
     */
    public void setPaddle(Rectangle paddle) {
        this.paddle = paddle;
    }

    /**
     * Function sets speed with the given speed.
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Function sets the paddle's color with the given color.
     * @param color
     */

    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * Function sets a KeyboardSensor with the given keyboard.
     * @param keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }
    /**
     * @return color.
     */
    public Color getColor() {
        return color;
    }
    /**
     * @return keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }
    /**
     *
     */
    public void moveLeft() {
        if (this.paddle.getUpperLeft().getX() - 10 <= BORDER_WIDTH) {
            this.paddle.getUpperLeft().setX(BORDER_WIDTH);
        } else {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() - this.speed);
        }
    }
    /**
     *
     */
    public void moveRight() {
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() + this.speed >= WIDTH - BORDER_WIDTH) {
            this.paddle.getUpperLeft().setX(WIDTH - BORDER_WIDTH - this.paddle.getWidth());
        } else {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() + this.speed);
        }
    }

    // Sprite
    /**
     *
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     *
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        int startX = (int) this.paddle.getUpperLeft().getX();
        int startY = (int) this.paddle.getUpperLeft().getY();
        d.fillRectangle(startX, startY, (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
        //Outline the rectangle
        d.setColor(Color.BLACK);
        d.drawRectangle(startX, startY, (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    // Collidable
    /**
     *
     * @return
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     *
     * @param hitter
     * @param currentVelocity
     * @return
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (Math.abs(collisionPoint.getX() - this.paddle.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - (this.paddle.getUpperLeft().getX() + this.paddle.getWidth()))
                < epsilon) {
            currentVelocity.setVelocityX(-currentVelocity.getDx());
        }
        if (Math.abs(collisionPoint.getY() - this.paddle.getUpperLeft().getY()) < epsilon
                || Math.abs(collisionPoint.getY() - (this.paddle.getUpperLeft().getY() + this.paddle.getHeight()))
                < epsilon) {
            double widthRegion = this.paddle.getWidth() / 5;
            if ((Math.abs(collisionPoint.getX() - this.paddle.getUpperLeft().getX()) < epsilon
                    || Math.abs(collisionPoint.getX() - (this.paddle.getUpperLeft().getX() + this.paddle.getWidth()))
                    < epsilon)
                    || (collisionPoint.getX() > this.paddle.getUpperLeft().getX() + 2 * widthRegion
                    && collisionPoint.getX() <= this.paddle.getUpperLeft().getX() + 3 * widthRegion)) {
                //corners and region 3
                currentVelocity.setVelocityY(-currentVelocity.getDy());
            } else {
                if (collisionPoint.getX() > this.paddle.getUpperLeft().getX()
                        && collisionPoint.getX() <= this.paddle.getUpperLeft().getX() + widthRegion) { // region 1
                    currentVelocity = currentVelocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
                } else {
                    if (collisionPoint.getX() > this.paddle.getUpperLeft().getX() + widthRegion
                            && collisionPoint.getX() <= this.paddle.getUpperLeft().getX() + 2 * widthRegion) {
                        // region 2
                        currentVelocity = currentVelocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
                    } else {
                        if (collisionPoint.getX() > this.paddle.getUpperLeft().getX() + 3 * widthRegion
                                && collisionPoint.getX() <= this.paddle.getUpperLeft().getX() + 4 * widthRegion) {
                            // region 3
                            currentVelocity = currentVelocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
                        } else {
                            if (collisionPoint.getX() > this.paddle.getUpperLeft().getX() + 4 * widthRegion
                                    && collisionPoint.getX() < this.paddle.getUpperLeft().getX() + 5 * widthRegion) {
                                // region 3
                                currentVelocity = currentVelocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
                            }
                        }
                    }
                }
            }
        }
        return currentVelocity;
    }
    /**
     * Function adds this paddle to the game.
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}