package edu.northeastern.question1;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public void getArea() {
        double area = 3.1415 * radius * radius;
        super.setArea(area);
        super.getArea();
    }

    public void getPerimeter() {
        double perimeter = 2 * 3.1415 * radius;
        super.setPerimeter(perimeter);
        super.getPerimeter();
    }
}
