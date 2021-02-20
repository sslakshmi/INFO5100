package edu.northeastern.question3;

public class DessertShop {
    public static final double TAX_RATE = 0.065;
    public static final String STORE_NAME = "M & M Dessert Shoppe";
    public static final int MAX_SIZE_OF_ITEM_NAME = 23;
    public static final int WIDTH_TO_DISPLAY_COST = 10;


    /**
     * Takes an integer number of cents and returns it as a String formatted in dollars and cents
     * example : 105 cents would be returned as "1.05"
     *
     * @param cents
     * @return
     */
    public static String cents2dollarsAndCents(int cents) {
        return ((Double) (cents / 100.0)).toString();
    }

    //Used to split the dessert item name when the length exceeds the MAX_SIZE_OF_ITEM_NAME
    public static String splitName(String itemName) {
        StringBuilder name = new StringBuilder();
        String temp = itemName;
        while (temp.length() > MAX_SIZE_OF_ITEM_NAME) {
            int lastIndexOfSpace = temp.substring(0, MAX_SIZE_OF_ITEM_NAME - 1).lastIndexOf(' ');
            name.append(String.format("%-" + MAX_SIZE_OF_ITEM_NAME + "s", temp.substring(0, lastIndexOfSpace)));
            name.append("\n");
            temp = temp.substring(lastIndexOfSpace + 1);
        }
        if (temp.length() > 0) {
            name.append(String.format("%-" + MAX_SIZE_OF_ITEM_NAME + "s", temp));
        }
        return name.toString();
    }
}
