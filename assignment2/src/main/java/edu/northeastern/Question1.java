package edu.northeastern;

public class Question1 {
//    Write a java function that adds all the digits of an integer until it is single digit. (You may assume that input is a positive number)
//    i. function takes an integer as input and returns its sum of digits.
//    ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.

    public int addDigits(int input) {
        int singleDigitSum = addDigitsRecursive(input);
        return singleDigitSum;
    }

    private int addDigitsRecursive(int input) {
        if (input < 10) {
            return input;
        }
        int sumOfDigits = 0;
        while (input > 0) {
            sumOfDigits += input % 10;
            input = input / 10;
        }
        return addDigitsRecursive(sumOfDigits);
    }
}
