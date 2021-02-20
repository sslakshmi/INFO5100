package edu.northeastern.question1;

import java.math.RoundingMode;
import java.text.DecimalFormat;

//TODO - Should we add getters and setters for all the properties?
public class Shape {
    private final DecimalFormat decimalFormat;
    private String name;
    private double perimeter;
    private double area;

    public Shape() {
        this("Shape");
    }

    public Shape(String name) {
        this.name = name;
        decimalFormat = new DecimalFormat("#.0#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getPerimeter() {
        System.out.println(decimalFormat.format(this.perimeter));
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void getArea() {
        System.out.println(decimalFormat.format(this.area));
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void draw() {
        System.out.println(String.format("Drawing %s", this.name));
    }

}
