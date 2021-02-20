package edu.northeastern.question3;

public class IceCream extends DessertItem {
    private final int cost;

    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(DessertShop.splitName(getName()));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s", DessertShop.cents2dollarsAndCents(getCost())));
        return outString.toString();
    }
}
