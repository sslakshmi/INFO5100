package edu.northeastern;

public class Question2 {
//    Write a method to find the maximum and minimum number in an array of numbers
//    Example:
//    Input : [3, 5, 7, 1, 4, 32, 15]
//    Output : Max is 32 and Min is 1

    public void findMaxAndMin(int[] array) {
        int minimum = 0;
        int maximum = 0;
        if (array.length > 0) {
            minimum = array[0];
            maximum = array[0];
            for (int i = 1; i < array.length; i++) {
                if (minimum > array[i]) {
                    minimum = array[i];
                }
                if (maximum < array[i]) {
                    maximum = array[i];
                }
            }
        }
        System.out.print("Max is " + maximum + " and Min is " + minimum);
    }
}
