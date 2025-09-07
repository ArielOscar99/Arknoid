import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ariel Oscar id: 209341684
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Function constructs a new rectangle with location and width, height.
     * @param upperLeft
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.setUpperLeft(upperLeft);
        this.setWidth(width);
        this.setHeight(height);
    }
    /**
     * Function returns a (possibly empty) List of intersection points with the specified line.
     * @param line
     * @return list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();
        Line line1, line2, line3, line4;
        Point temp = new Point();
        line1 = new Line(this.upperLeft.getX(), this.upperLeft.getY(), this.upperLeft.getX(),
                this.upperLeft.getY() + this.height);
        line2 = new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        line3 = new Line(this.upperLeft.getX(), this.upperLeft.getY(), this.upperLeft.getX() + this.width,
                this.upperLeft.getY());
        line4 = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        temp = line.intersectionWith(line1);
        if (temp != null) {
            list.add(temp);
        }
        temp = line.intersectionWith(line2);
        if (temp != null) {
            list.add(temp);
        }
        temp = line.intersectionWith(line3);
        if (temp != null) {
            list.add(temp);
        }
        temp = line.intersectionWith(line4);
        if (temp != null) {
            list.add(temp);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }
    /**
     *
     * @param upperLeft
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     * @return width
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return height
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}