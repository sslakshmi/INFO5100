package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Question1Test {

    private static Question1 question1;

    @BeforeAll
    public static void init() {
        question1 = new Question1();
    }

    @Test
    void addDigitsTest1() {
        int sumOfDigits = question1.addDigits(37);
        Assertions.assertEquals(1, sumOfDigits);
    }

    @Test
    void addDigitsTest2() {
        int sumOfDigits = question1.addDigits(103);
        Assertions.assertEquals(4, sumOfDigits);
    }

    @Test
    void addDigitsTest3() {
        int sumOfDigits = question1.addDigits(9999);
        Assertions.assertEquals(9, sumOfDigits);
    }

    @Test
    void addDigitsTest4() {
        int sumOfDigits = question1.addDigits(99999999);
        Assertions.assertEquals(9, sumOfDigits);
    }

    @Test
    void addDigitsTest5() {
        int sumOfDigits = question1.addDigits(0);
        Assertions.assertEquals(0, sumOfDigits);
    }
}