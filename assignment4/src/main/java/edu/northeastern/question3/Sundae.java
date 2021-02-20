package edu.northeastern.question3;

public class Sundae extends IceCream {
    private final String toppingName;
    private final int toppingCost;

    public String getToppingName() {
        return toppingName;
    }

    public int getToppingCost() {
        return toppingCost;
    }

    public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingCost) {
        super(iceCreamName, iceCreamCost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        return super.getCost() + getToppingCost();
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        String itemName = getToppingName() + " Sundae with " + super.getName();
        outString.append(DessertShop.splitName(itemName));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s", DessertShop.cents2dollarsAndCents(getCost())));
        return outString.toString();
    }
}
