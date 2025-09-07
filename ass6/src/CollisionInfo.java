/**
 * @author: Ariel Oscar id: 209341684
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidableObject;

    /**
     * Function construct a new CollisionInfo.
     * @param collisionPoint
     * @param collidableObject
     */
    public CollisionInfo(Point collisionPoint, Collidable collidableObject) {
        this.setCollisionPoint(collisionPoint);
        this.setCollidableObject(collidableObject);
    }
    /**
     * Function sets collisionPoint.
     * @param collisionPoint
     */
    public void setCollisionPoint(Point collisionPoint) {
        this.collisionPoint = collisionPoint;
    }
    /**
     * Function sets collidableObject.
     * @param collidableObject
     */
    public void setCollidableObject(Collidable collidableObject) {
        this.collidableObject = collidableObject;
    }
    /**
     * @return the point at which the collision occurs.
     */
    public Point getCollisionPoint() {
        return this.collisionPoint;
    }
    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable getCollidableObject() {
        return this.collidableObject;
    }
}