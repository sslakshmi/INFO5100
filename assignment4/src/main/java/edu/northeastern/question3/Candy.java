package edu.northeastern.question3;

public class Candy extends DessertItem {
    private final double weight;
    private final int pricePerPound;

    public double getWeight() {
        return weight;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        //2.25 lbs. @ 3.99 /lb.
        return (int) Math.round(getWeight() * getPricePerPound());
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(String.format("%-" + DessertShop.MAX_SIZE_OF_ITEM_NAME + "s", getWeight() + "lbs. @ " + DessertShop.cents2dollarsAndCents(getPricePerPound()) + "/lb."));
        outString.append("\n");
        outString.append(DessertShop.splitName(getName()));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s", DessertShop.cents2dollarsAndCents(getCost())));
        return outString.toString();
    }
}
