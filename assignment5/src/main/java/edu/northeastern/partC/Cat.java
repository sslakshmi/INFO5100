package edu.northeastern.partC;

import java.time.LocalDate;

public class Cat extends Pet implements Boardable {

    private final String hairLength;
    private LocalDate startDate;
    private LocalDate endDate;

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Tom", "Bob", "black", "short");
        cat.setSex(2);
        System.out.println(cat.toString());
        cat.setBoardStart(1, 10, 2021);
        cat.setBoardEnd(1, 15, 2021);
        System.out.println(cat.boarding(1, 12, 2021));
        //Test
        System.out.println(cat.boarding(1, 10, 2021));
        System.out.println(cat.boarding(1, 15, 2021));
        System.out.println(cat.boarding(1, 9, 2021));
        System.out.println(cat.boarding(1, 16, 2021));

    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toUpperCase() +
                ":\n" +
                super.toString() +
                "\n" +
                "Hair: " + this.getHairLength();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startDate = LocalDate.of(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endDate = LocalDate.of(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return (this.startDate.isBefore(date) && this.endDate.isAfter(date)) ||
                this.startDate.isEqual(date) ||
                this.endDate.isEqual(date);
    }
}
