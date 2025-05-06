import java.util.Objects;

public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        Circle circle = (Circle) o;
        return this.radius == circle.radius;
    }

    @Override
    public String toString() {
        return "Circle radius = " + radius;
    }
}
