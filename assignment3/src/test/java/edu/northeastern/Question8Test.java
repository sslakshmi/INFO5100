package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question8Test {

    @Test
    void convertTestTest1() {
        Question8 question8 = new Question8();
        String input = "PAYPALISHIRING";
        System.out.println(question8.convert(input, 3));
        Assertions.assertEquals("PAHNAPLSIIGYIR",question8.convert(input, 3));
    }

    @Test
    void convertTestTest2() {
        Question8 question8 = new Question8();
        String input = "PAYPALISHIRING";
        System.out.println(question8.convert(input, 4));
        Assertions.assertEquals("PINALSIGYAHRPI",question8.convert(input, 4));
    }
}