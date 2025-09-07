import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ariel Oscar id: 209341684
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Function constructs a new List of Collidables.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }
    /**
     * @return collidables.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * Function sets collidables list.
     * @param collidables
     */
    public void setCollidables(List<Collidable> collidables) {
        this.collidables = collidables;
    }

    /**
     * Function adds the given collidable to the Collidables list.
     * @param c
     */
    public void addCollidable(Collidable c) {
        if (c != null) {
            this.collidables.add(c);
        }
    }
    /**
     * Function removes the given collidable from the Collidables list.
     * @param c
     */
    public void removeCollidable(Collidable c) {
        if (this.collidables.contains(c)) {
            this.collidables.remove(c);
        }
    }
    /**
     * Assume an object moving from line.start() to line.end(). If this object will not collide with any of the
     * collidables in this collection, return null. Else, return the information about the closest collision that is
     * going to occur.
     * @param trajectory
     * @return Closest collisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (collidables == null) {
            return null;
        }
        Point p = new Point();
        int i;
        for (i = 0; i < collidables.size(); i++) {
            p = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (p != null) {
                break;
            }
        }
        if (i == collidables.size()) {
            return null;
        }
        CollisionInfo closest;
        if (i == collidables.size() - 1) {
            closest = new CollisionInfo(p, collidables.get(i));
            return closest;
        }
        int numOfCollidable = i;
        Point temp;
        for (i = numOfCollidable + 1; i < collidables.size(); i++) {
            temp = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (temp != null && trajectory.getStart().distance(temp) < trajectory.getStart().distance(p)) {
                p = temp;
                numOfCollidable = i;
            }
        }
        closest = new CollisionInfo(p, collidables.get(numOfCollidable));
        return closest;
    }
}