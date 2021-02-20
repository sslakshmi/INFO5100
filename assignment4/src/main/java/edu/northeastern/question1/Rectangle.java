package edu.northeastern.question1;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        super("rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public void getArea() {
        double area = width * height;
        super.setArea(area);
        super.getArea();
    }

    @Override
    public void getPerimeter() {
        double perimeter = 2 * (width + height);
        super.setPerimeter(perimeter);
        super.getPerimeter();
    }
}
