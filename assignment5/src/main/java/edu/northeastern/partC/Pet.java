package edu.northeastern.partC;

public class Pet {

    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;
    protected int sex;
    private final String petName;
    private final String ownerName;
    private final String color;

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public static void main(String[] args) {
        Pet pet = new Pet("Spot", "Mary", "Black and White");
        pet.setSex(0);
        System.out.println(pet.toString());
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        switch (this.sex) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            case SPAYED:
                return "Spayed";
            case NEUTERED:
                return "Neurered";
            default:
                return "Invalid sex";
        }
    }

    public void setSex(int sexid) {
        if (sexid >= 0 && sexid <= 3) {
            sex = sexid;
        } else {
            System.out.println("Invalid sexid!!!");
        }
    }

    @Override
    public String toString() {
        return this.getPetName() +
                " owned by " +
                this.getOwnerName() +
                "\n" +
                "Color: " +
                getColor() +
                "\n" +
                "Sex: " +
                getSex();
    }
}
