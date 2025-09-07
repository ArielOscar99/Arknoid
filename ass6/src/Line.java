import java.util.List;

/**
 * @author Ariel Oscar 209341684
 */
public class Line {
    private final double epsilon = Math.pow(10, -10);
    private Point start;
    private Point end;

    /**
     * The function get start and end points and builds a line object.
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        this.setStart(start);
        this.setEnd(end);
    }
    /**
     * The function gets x and y of start and gets x and y of end and builds a line object.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.setStart(start);
        this.setEnd(end);
    }
    /**
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * @return the middle point of the line
     */
    public Point middle() {
        Point middle = new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
        return middle;
    }
    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }
    /**
     * @param other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) != null) {
            return true;
        }
        double a1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double a2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        double b1 = ((-a1) * this.start.getX()) + this.start.getY();
        double b2 = ((-a2) * other.start.getX()) + other.start.getY();
        if (a1 != a2) {
            return false;
        } else { //The lines are parallel or the same line.
           if (b1 != b2) { //The lines are parallel.
               return false;
           } else { //The same line.
               if (((other.start.getX() <= Math.max(this.start.getX(), this.end.getX()))
                       && (other.start.getX() >= Math.min(this.start.getX(), this.end.getX())))
                       || ((other.end.getX() <= Math.max(this.start.getX(), this.end.getX()))
                       && (other.end.getX() >= Math.min(this.start.getX(), this.end.getX())))
                       || ((other.start.getY() <= Math.max(this.start.getY(), this.end.getY()))
                       && (other.start.getY() >= Math.min(this.start.getY(), this.end.getY())))
                       || ((other.end.getY() <= Math.max(this.start.getY(), this.end.getY()))
                       && (other.end.getY() >= Math.min(this.start.getY(), this.end.getY())))) {
                   return true;
               }
           }
        }
        return false;
    }
    /**
     * @param other line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (Math.abs(this.start.getX() - this.end.getX()) < epsilon) {
            if (Math.abs(other.start.getX() - other.end.getX()) < epsilon) {
                return null;
            }
            if (Math.min(other.start.getX(), other.end.getX()) <= this.start.getX()
                    && Math.max(other.start.getX(), other.end.getX()) >= this.start.getX()) {
                double m1 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
                double b1 = ((-m1) * other.start.getX()) + other.start.getY();
                double y = m1 * this.start.getX() + b1;
                if (Math.min(this.start.getY(), this.end.getY()) <= y
                        && Math.max(this.start.getY(), this.end.getY()) >= y) {
                    Point point = new Point(this.start.getX(), y);
                    return point;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        if (Math.abs(other.start.getX() - other.end.getX()) < epsilon) {
            if (Math.min(this.start.getX(), this.end.getX()) <= other.start.getX()
                    && Math.max(this.start.getX(), this.end.getX()) >= other.start.getX()) {
                double m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
                double b1 = ((-m1) * this.start.getX()) + this.start.getY();
                double y =  m1 * other.start.getX() + b1;
                if (Math.min(other.start.getY(), other.end.getY()) <= y
                        && Math.max(other.start.getY(), other.end.getY()) >= y) {
                    Point point = new Point(other.start.getX(), y);
                    return point;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        double a1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double a2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        double b1 = ((-a1) * this.start.getX()) + this.start.getY();
        double b2 = ((-a2) * other.start.getX()) + other.start.getY();
        if (Math.abs(a1 - a2) < epsilon) { //The lines are parallel or the same line.
            return null;
        } else { //Lines are intersecting
            double x = (b2 - b1) / (a1 - a2);
            double y = a1 * x + b1;
            if (((x <= Math.max(this.start.getX(), this.end.getX()))
                    && (x >= Math.min(this.start.getX(), this.end.getX())))
                    && ((x <= Math.max(other.start.getX(), other.end.getX()))
                    && (x >= Math.min(other.start.getX(), other.end.getX())))) {
                Point point = new Point(x, y);
                return point;
            } else { //The intersection point is not on both of the lines.
                return null;
            }
        }
    }
    /**
     * Function returns the closest intersection point to the start of the line. If this line does not intersect with
     * the rectangle, returns null.
     * @param rect
     * @return closest intersection to start of line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect == null) {
            return null;
        }
        Point point = new Point();
        List<Point> list = rect.intersectionPoints(this);
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return this.getStart().distance(list.get(0)) < this.getStart().distance(list.get(1))
                ? list.get(0) : list.get(1);
    }
    /**
     * @param other line
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if ((this.start().equals(other.start) && this.end().equals(other.end))
                || (this.start().equals(other.end) && this.end().equals(other.start))) {
            return true;
        }
        return false;
    }
    /**
     * Function gets a start points and se the start point of this.
     * @param start point
     */
    public void setStart(Point start) {
        this.start = start;
    }
    /**
     * Function gets an end points and se the start point of this.
     * @param end point
     */
    public void setEnd(Point end) {
        this.end = end;
    }
    /**
     * @return start point of this.
     */
    public Point getStart() {
        return this.start;
    }
    /**
     * @return end point of this.
     */
    public Point getEnd() {
        return this.end;
    }

    /**
     *
     * @return the incline of a line
     */
    public double getM() {
        return  (double) (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

}