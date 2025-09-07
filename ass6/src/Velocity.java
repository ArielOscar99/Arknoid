/**
 * @author Ariel Oscar id: 209341684
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * Function construct the velocity according to the given dx and dy.
     * @param dx
     * @param dy
     */
    public Velocity(double dx, double dy) {
        this.setVelocityX(dx);
        this.setVelocityY(dy);
    }
    /**
     * Function sets the Dx of velocity.
     * @param dx
     */
    public void setVelocityX(double dx) {
        this.dx = dx;
    }
    /**
     * Function sets the Dy of velocity.
     * @param dy
     */
    public void setVelocityY(double dy) {
        this.dy = dy;
    }
    /**
     * @return velocity
     */
    public Velocity getVelocity() {
        return this;
    }
    /**
     * @return Dx
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * @return Dy
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * @return speed
     */
    public double getSpeed() {
        return  Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }
    /**
     * Function return the velocity according to the given angle and speed.
     * @param angle
     * @param speed
     * @return new velocity
     **/
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy, dx;
        dx = (speed * Math.sin(Math.toRadians(angle)));
        dy = -(speed * Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }
    /**
     * Function Takes a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p
     * @return point
     */
    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return point;
    }
}