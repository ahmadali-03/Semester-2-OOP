import java.util.Objects;

public class Rectangle extends Shape2D {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public boolean equals(Object o) {
        Rectangle rectangle = (Rectangle) o;
        return this.width == rectangle.width && this.length == rectangle.length;
    }

    @Override
    public String toString() {
        return "Rectangle area = " + this.area();
    }
}
