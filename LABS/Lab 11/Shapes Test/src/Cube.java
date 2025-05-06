import java.util.Objects;

public class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area(){
        return side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }

    @Override
    public boolean equals(Object o) {
        Cube cube = (Cube) o;
        return this.side == cube.side;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(side);
    }

    @Override
    public String toString() {
        return "Cube area = " + this.area() + "\n   Cube volume = " + this.volume();
    }
}
