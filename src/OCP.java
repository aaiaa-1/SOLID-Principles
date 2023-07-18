
//Before applying OCP:

//In the code bellow, the Shape class has a draw() method that checks the ShapeType and performs the drawing logic based on the type.
// This violates the OCP because when adding a new shape, you'll have to modify the existing class by adding an additional condition in the draw() method.
enum ShapeType {
    CIRCLE,
    SQUARE
}

class ShapeNoOCP {
    private ShapeType type;

    public ShapeNoOCP(ShapeType type) {
        this.type = type;
    }

    public void draw() {
        if (type == ShapeType.CIRCLE) {
            drawCircle();
        } else if (type == ShapeType.SQUARE) {
            drawSquare();
        }
    }

    private void drawCircle() {
        System.out.println("Drawing a circle");
    }

    private void drawSquare() {
        System.out.println("Drawing a square");
    }
}

//  After applying OCP:

// In the refactored code, we introduce an abstract Shape class that defines an abstract draw() method.
// This makes the Shape class open for extension (new shapes can be added) and closed for modification (existing shapes don't need to be modified).
// We then create specific shape classes (Circle and Square) that extend the Shape class and provide their own implementation of the draw() method.

abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

//Now, let's see how we can use these classes in the main class:
class MainOCP {
    public static void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        drawShape(circle);  // Output: Drawing a circle
        drawShape(square);  // Output: Drawing a square
    }
}

//In the Main class, we have a drawShape() method that takes a Shape object as a parameter and calls its draw() method.
//In the main() method, we create instances of Circle and Square and pass them to the drawShape() method.
// As per the OCP, the drawShape() method is open for accepting ANY shape that extends the Shape class without requiring any modifications.
// This way, new shapes can be easily added without changing the existing and well-tested code.
