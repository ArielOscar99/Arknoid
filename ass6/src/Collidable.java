/**
 * @author: Ariel Oscar id: 209341684
 */
public interface Collidable {
    /**
     * @return Rectangle - the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /**
     * Function notifies the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint
     * @param currentVelocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}