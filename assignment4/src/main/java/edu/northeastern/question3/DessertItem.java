package edu.northeastern.question3;

public abstract class DessertItem {
    private String name;

    public DessertItem() {}

    public DessertItem(String name) {
        this.name = name;
    }

    public abstract int getCost();

    /**
     * Returns name of dessert item
     * @return
     */
    //TODO - Calculating tax specification
    public final String getName() {
        return name;
    }
}
