/**
 * @author Ariel Oscar 209341684
 */
public class Point {
    private final double epsilon = Math.pow(10, -10);
    private double x;
    private double y;

    /**
     * Default constructor.
     */
    public Point() {

    }
    /**
     * Function gets x and y and build a new point with the values.
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    /**
     * Function gets a point and calculates the distance between this point and the other point.
     * @param other
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * Function gets a point checks if they are equals.
     * @param other
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (Math.abs(this.x - other.getX()) < epsilon && Math.abs(this.y - other.getY()) < epsilon) {
            return true;
        }
        return false;
    }
    /**
     * Function gets a x value and sets the x value of this point.
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Function gets a y value and sets the x value of this point.
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * @return the x value of this point
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return the y value of this point
     */
    public double getY() {
        return this.y;
    }
}
