package edu.northeastern.partA;

import java.util.ArrayList;

public class Mreview implements Comparable<Mreview> {

    private final String title;
    private final ArrayList<Integer> ratings;

    /**
     * Sets title to "" and creates an empty ArrayList to ratings.
     */
    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    /**
     * Sets title to the parameter string and creates an empty ArrayList to ratings.
     *
     * @param ttl
     */
    public Mreview(String ttl) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
    }

    /**
     * Sets title to the parameter string and creates a ratings list whose size() is one, having the parameter int as
     * the (only/first) element.
     *
     * @param ttl
     * @param firstRating
     */
    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
        this.ratings.add(firstRating);
    }

    public static void main(String[] args) {
        Mreview mreview = new Mreview("Drishyam");
        mreview.addRating(3);
        mreview.addRating(4);
        mreview.addRating(5);
        System.out.println(mreview.toString());
    }

    /**
     * Inserts the parameter rating in the ratings list.
     *
     * @param r
     */
    public void addRating(int r) {
        getRatings().add(r);
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Returns the average of the ratings stored in the rating list.
     *
     * @return
     */
    public double aveRating() {
        int total = 0;
        for (int rating : getRatings()) {
            total += rating;
        }
        return total / numRatings();
    }

    /**
     * Returns the size (not capacity) of the rating list.
     *
     * @return
     */
    public int numRatings() {
        return getRatings().size();
    }

    /**
     * Overrides the abstract method defined in Comparable interface. To determine the order of two Mreview's, only the
     * titles are considered and their order translates the order of Mreview's directly.
     *
     * @param obj - Another Object to be compared for the order.
     * @return - a negative number if this title is before the title of the parameter object, or a positive number if
     * this title is after the title of the parameter object, or 0 otherwise.
     */
    @Override
    public int compareTo(Mreview obj) {
        return this.title.compareTo(obj.title);
    }

    /**
     * Overrides the method derived from Object. To determine the (content) equality of two Mreview's, only the titles
     * are considered -- if this title is "equals" to the title of the parameter object. Casting is required to make
     * the parameter a Mreview object.
     *
     * @param obj - Another Object to be compared for the order. Casting is required to make the parameter a
     *            Mreview object.
     * @return - true if two title String's are equal, or false otherwise.
     */
    public boolean equals(Object obj) {
        Mreview mObject = (Mreview) obj;
        return this.title.equals(mObject.getTitle());
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append(this.getTitle())
                .append(", average ")
                .append(this.aveRating())
                .append(" out of ")
                .append(this.numRatings())
                .append(" ratings");
        return outString.toString();
    }

}


