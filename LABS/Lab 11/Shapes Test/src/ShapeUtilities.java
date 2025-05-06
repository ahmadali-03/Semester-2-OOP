public class ShapeUtilities {

    public static void shapeCount(Shape[] shapes) {

        int circleCount = 0;
        int rectangleCount = 0;
        int sphereCount = 0;
        int cubeCount = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                circleCount++;
            }
            else if (shape instanceof Rectangle) {
                rectangleCount++;
            }
            else if (shape instanceof Sphere) {
                sphereCount++;
            }
            else if (shape instanceof Cube) {
                cubeCount++;
            }
        }

        System.out.println("Circle Shapes: " + circleCount + "\nRectangle shapes: " +rectangleCount + "\nSphere shapes: " +sphereCount + "\nCube shapes: " +cubeCount);
    }

    public static void countEqual(Shape[] shapes) {
        int circleCount = 0;
        int rectangleCount = 0;
        int sphereCount = 0;
        int cubeCount = 0;

        for (int i=0; i<shapes.length; i++) {
            if (shapes[i] instanceof Circle) {
                for(int j = i + 1; j<shapes.length; j++) {
                    if (shapes[j] instanceof Circle){
                        if (shapes[i].equals(shapes[j]))
                            circleCount++;
                    }
                }
            }
            else if (shapes[i] instanceof Rectangle) {
                for(int j = i + 1; j<shapes.length; j++) {
                    if (shapes[j] instanceof Rectangle){
                        if (shapes[i].equals(shapes[j]))
                            rectangleCount++;
                    }
                }
            }
            else if (shapes[i] instanceof Sphere) {
                for(int j = i + 1; j<shapes.length; j++) {
                    if (shapes[j] instanceof Sphere){
                        if (shapes[i].equals(shapes[j]))
                            sphereCount++;
                    }
                }
            }
            else if (shapes[i] instanceof Cube) {
                for(int j = i + 1; j<shapes.length; j++) {
                    if (shapes[j] instanceof Cube){
                        if (shapes[i].equals(shapes[j]))
                            cubeCount++;
                    }
                }
            }
        }

        System.out.println("Equal Circle: " + circleCount + "\nEqual Rectangle: " +rectangleCount + "\nEqual Sphere: " +sphereCount + "\nEqual Cube: " +cubeCount);
    }
}
