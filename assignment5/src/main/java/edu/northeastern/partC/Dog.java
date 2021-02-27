package edu.northeastern.partC;

import java.time.LocalDate;

public class Dog extends Pet implements Boardable {
    private final String size;
    private LocalDate startDate;
    private LocalDate endDate;

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Spot", "Susan", "white", "medium");
        dog.setSex(2);
        System.out.println(dog.toString());
        dog.setBoardStart(1, 10, 2021);
        dog.setBoardEnd(1, 15, 2021);
        System.out.println(dog.boarding(1, 12, 2021));
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toUpperCase() +
                "\n" +
                super.toString() +
                "\n" +
                "Size: " + this.getSize();
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
