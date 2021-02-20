package edu.northeastern.question1;

public class Square extends Shape {
    private final double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    @Override
    public void getArea() {
        double area = side * side;
        super.setArea(area);
        super.getArea();
    }

    @Override
    public void getPerimeter() {
        double perimeter = 4 * side;
        super.setPerimeter(perimeter);
        super.getPerimeter();
    }
}
