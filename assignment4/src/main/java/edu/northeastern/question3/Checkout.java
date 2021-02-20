package edu.northeastern.question3;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private final List<DessertItem> dessertItemList;

    public Checkout() {
        this.dessertItemList = new ArrayList<>();
    }

    /**
     * Returns the number of dessert items in the list
     *
     * @return
     */
    public int numberOfItems() {
        return dessertItemList.size();
    }

    /**
     * A new dessert item is added to the end of the list
     *
     * @param item
     */
    public void enterItem(DessertItem item) {
        dessertItemList.add(item);
    }

    /**
     * Clears the checkout to begin checking out a new set of items
     */
    public void clear() {
        dessertItemList.clear();
    }

    /**
     * Returns total cost of items in cents (without tax)
     *
     * @return
     */
    public int totalCost() {
        int totalCost = 0;
        for (DessertItem item : dessertItemList) {
            totalCost = totalCost + item.getCost();
        }
        return totalCost;
    }

    /**
     * Returns total tsx on items in cents
     *
     * @return
     */
    public int totalTax() {
        return (int) Math.round(totalCost() * DessertShop.TAX_RATE);
    }

    /**
     * Returns a String representing a receipt for the current list of dessert items with the name of the Dessert store,
     * the items purchased, the tax, and the total cost
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        int storeNameLength = DessertShop.STORE_NAME.length();
        Integer leftSpacing = ((DessertShop.MAX_SIZE_OF_ITEM_NAME + DessertShop.WIDTH_TO_DISPLAY_COST) - storeNameLength) / 2;
        outString.append(String.format("%-" + leftSpacing + "s%s", "", DessertShop.STORE_NAME));
        outString.append("\n");
        outString.append(String.format("%-" + leftSpacing + "s%s", "", "-".repeat(storeNameLength)));
        outString.append("\n");
        for (DessertItem item : dessertItemList) {
            outString.append(item.toString());
            outString.append("\n");
        }
        outString.append(String.format("%-" + DessertShop.MAX_SIZE_OF_ITEM_NAME + "s", "Tax"));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s", DessertShop.cents2dollarsAndCents(totalTax())));
        outString.append("\n");
        outString.append(String.format("%-" + DessertShop.MAX_SIZE_OF_ITEM_NAME + "s", "Total Cost"));
        outString.append(String.format("%" + DessertShop.WIDTH_TO_DISPLAY_COST + "s",DessertShop.cents2dollarsAndCents(totalCost() + totalTax())));
        outString.append("\n");
        return outString.toString();
    }
}
