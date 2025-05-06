
public class ShapeTest {

    public static void main(String[] args) {

        Shape shape1;
        Shape2D shape2D1;
        Shape3D shape3D1;
        Shape[] shapes = new Shape[20];

        /*Circle circle1 = new Circle(1);
        Rectangle rectangle1 = new Rectangle(1,2);
        Sphere sphere1 = new Sphere(1) ;
        Cube cube1 = new Cube(5);
        circle1.setRadius(5);
        System.out.println("circle1 area: " + circle1.area());
        rectangle1.setLength(10);
        rectangle1.setWidth(5);
        System.out.println("rectangle1 area: " + rectangle1.area());
        sphere1.setRadius(5);
        System.out.println("sphere1 volume: " + sphere1.volume());
        System.out.println("sphere1 area: " + sphere1.area());
        cube1.setSide(5);
        System.out.println("cube1 volume: " + cube1.volume());
        System.out.println("cube1 area: " + cube1.area());*/

        for (int i = 0; i < shapes.length; i++) {
            if (i < 5)
                shapes[i] = new Circle(i + 1);
            if (i > 4 && i < 10)
                shapes[i] = new Rectangle(i+1, i + 2);
            if (i > 9 && i < 15)
                shapes[i] = new Sphere(i+2);
            if (i > 14 && i < 20)
                shapes[i] = new Cube(i+3);
        }

        for(int i = 0; i < shapes.length; i++){
            System.out.println(i + 1 +" " +shapes[i]);
        }

        for(int i =0; i < shapes.length; i++){
            if(shapes[i] instanceof Rectangle){
                ((Rectangle) shapes[i]).setLength(10);
            }
        }

        System.out.println("\nNumber of same shapes:");
        ShapeUtilities.shapeCount(shapes);
        System.out.println("\nNumber of equal shapes:");
        ShapeUtilities.countEqual(shapes);
    }
}