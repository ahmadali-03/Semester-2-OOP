import java.util.Objects;

public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return 4 * Math.PI * radius * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        Sphere sphere = (Sphere) o;
        return this.getRadius() == sphere.getRadius();
    }

    @Override
    public String toString() {
        return "Sphere area = " + this.area() + "\n   Sphere volume = " + this.volume();
    }
}
