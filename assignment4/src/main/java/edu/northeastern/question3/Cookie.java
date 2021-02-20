package edu.northeastern.question3;

public class Cookie extends DessertItem {
    private final int number;
    private final int pricePerDozen;

    public int getNumber() {
        return number;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public int getCost() {
        return (int) Math.round((getNumber() / 12.0) * getPricePerDozen());
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(String.format("%-" + DessertShop.MAX_SIZE_OF_ITEM_NAME + "s", getNumber() + " @ " + DessertShop.cents2dollarsAndCents(getPricePerDozen()) + "/dz."));
        outString.append("\n");
        outString.append(DessertShop.splitName(getName()));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s", DessertShop.cents2dollarsAndCents(getCost())));
        return outString.toString();
    }
}
