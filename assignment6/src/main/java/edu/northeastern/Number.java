package edu.northeastern;

public class Number {
    int count(int a, int b) throws ArithmeticException {
        try {
            int quotient = 0;
            quotient = a / b;
            return quotient;
        } catch (ArithmeticException e) {
            System.out.println(e);
            throw e;
        }
    }
}
