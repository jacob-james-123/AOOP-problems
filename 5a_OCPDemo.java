package tasks.Task5.t2;

// Abstract class for Shapes
abstract class Shape {
    public abstract double calculateArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Circle class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Main class to demonstrate the Open/Closed Principle
public class OCPDemo {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4, 5);
        Shape circle = new Circle(3);

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());
    }
}
