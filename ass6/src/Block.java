import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

/**
 * @author: Ariel Oscar id: 209341684
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final double epsilon = Math.pow(10, -10);
    private Rectangle block;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * Function constructs a new block.
     * @param block
     * @param color
     */
    public Block(Rectangle block, java.awt.Color color) {
        this.setBlock(block);
        this.setColor(color);
        hitListeners = new ArrayList<>();
    }
    /**
     * Function sets a block with a given block.
     * @param block
     */
    public void setBlock(Rectangle block) {
        this.block = block;
    }
    /**
     * Function sets a color with a given color.
     * @param color
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    /**
     * @return color of ball.
     */
    public java.awt.Color getColor() {
        return color;
    }
    /**
     * Function returns the rectangle of block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }
    /**
     * Function changes the velocity if the point is on the block.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (Math.abs(collisionPoint.getX() - this.block.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - (this.block.getUpperLeft().getX() + this.block.getWidth()))
                < epsilon) {
            currentVelocity.setVelocityX(-currentVelocity.getDx());
        }
        if (Math.abs(collisionPoint.getY() - this.block.getUpperLeft().getY()) < epsilon
                || Math.abs(collisionPoint.getY() - (this.block.getUpperLeft().getY() + this.block.getHeight()))
                < epsilon) {
            currentVelocity.setVelocityY(-currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        int startX = (int) this.block.getUpperLeft().getX();
        int startY = (int) this.block.getUpperLeft().getY();
        surface.fillRectangle(startX, startY, (int) this.block.getWidth(), (int) this.block.getHeight());
        //Outline the rectangle.
        if (this.color != Color.GRAY) {
            surface.setColor(Color.BLACK);
            surface.drawRectangle(startX, startY, (int) this.block.getWidth(), (int) this.block.getHeight());
        }
    }
    /**
     * Empty for now.
     */
    @Override
    public void timePassed() {
    }

    /**
     * Function removes a block from game.
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * @param hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        if (hl != null) {
            this.hitListeners.add(hl);
        }
    }
    /**
     * @param hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        if (this.hitListeners.contains(hl)) {
            this.hitListeners.remove(hl);
        }
    }
    /**
     *
     * @param hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
