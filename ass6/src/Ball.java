import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ariel Oscar id: 209341684
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment game;
    private List<HitListener> hitListeners;


    /**
     * Function builds a ball according to its center, radius, color and gameEnvironment.
     * @param center
     * @param r
     * @param color
     * @param game
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.setCenter(center);
        this.setRadius(r);
        this.setColor(color);
        this.setGameEnvironment(game);
        hitListeners = new ArrayList<>();
    }

    /**
     * Function builds a ball according to its x, y, radius and color.
     * @param x
     * @param y
     * @param r
     * @param color
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.setCenter(x, y);
        this.setRadius(r);
        this.setColor(color);
    }
    /**
     * Function sets the center point of ball.
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Function sets the center point of ball according to the given x and y.
     * @param x
     * @param y
     */
    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }
    /**
     * Function sets the x parameter of ball's center point.
     * @param x
     */
    public void setCenterX(int x) {
        this.center.setX((double) x);
    }
    /**
     * Function sets the x parameter of ball's center point.
     * @param y
     */
    public void setCenterY(int y) {
        this.center.setY((double) y);
    }
    /**
     * Function sets the radius of ball.
     * @param r
     */
    public void setRadius(int r) {
        this.r = r;
    }
    /**
     * Function sets the color of point.
     * @param color
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    /**
     * Function sets the velocity of ball.
     * @param v
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * Function sets the velocity of ball according to the given x and y.
     * @param dx
     * @param dy
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.velocity = v;
    }

    /**
     * Function sets the GameEnvironment of ball.
     * @param game
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.game = game;
    }

    /**
     * @return x of the ball's center.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return y of the ball's center.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return r of the ball.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * @return velocity of the ball.
     */
    public Velocity getVelocity() {
        return velocity;
    }
    /**
     * @return gameEnvironment
     */
    public GameEnvironment getGame() {
        return game;
    }

    /**
     * Function gets a surface and draw this ball on the given DrawSurface.
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        if (this.r <= 0 || this.r > surface.getHeight() || this.r > surface.getHeight()) {
            this.setRadius(1);
        }
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }
    /**
     * Function moves the ball one step according to its velocity.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Function sets the center of the ball to a different according to its velocity.
     */
    public void moveOneStep() {
        double x = this.getX(), y = this.getY();
        if (this.getVelocity().getDx() < 0) {
            x = this.getX() + this.getVelocity().getDx() - this.r + 1;
        } else {
            if (this.getVelocity().getDx() > 0) {
                x = this.getX() + this.getVelocity().getDx() + this.r - 1;
            }
        }
        if (this.getVelocity().getDy() < 0) {
            y = this.getY() + this.getVelocity().getDy() - this.r + 1;
        } else {
            if (this.getVelocity().getDy() > 0) {
                y = this.getY() + this.getVelocity().getDy() + this.r - 1;
            }
        }
        Point end = new Point(x, y);
        Line trajectory = new Line(this.center, end);
        CollisionInfo closest = this.game.getClosestCollision(trajectory);
        x = this.center.getX();
        y = this.center.getY();
        if (closest != null) {
            if (this.getVelocity().getDx() < 0) {
                x = closest.getCollisionPoint().getX() + this.r - 1;
            } else {
                if (this.getVelocity().getDx() > 0) {
                    x = closest.getCollisionPoint().getX() - this.r + 1;
                }
            }
            if (this.getVelocity().getDy() < 0) {
                y = closest.getCollisionPoint().getY() + this.r - 1;
            } else {
                if (this.getVelocity().getDy() > 0) {
                    y = closest.getCollisionPoint().getY() - this.r + 1;
                }
            }
            this.setCenter((int) x, (int) y);
            this.setVelocity(closest.getCollidableObject().hit(this, closest.getCollisionPoint(), this.velocity));
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
    /**
     * Function removes a block from game.
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}