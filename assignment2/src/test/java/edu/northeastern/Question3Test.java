package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question3Test {

    @Test
    void characterCountInStringTest1() {
        Question3 question3 = new Question3();
        int charCount = question3.characterCountInString("North",'r');
        Assertions.assertEquals(1, charCount);
    }

    @Test
    void characterCountInStringTest2() {
        Question3 question3 = new Question3();
        int charCount = question3.characterCountInString("cascade",'c');
        Assertions.assertEquals(2, charCount);
    }

    @Test
    void characterCountInStringTest3() {
        Question3 question3 = new Question3();
        int charCount = question3.characterCountInString("cascade",'y');
        Assertions.assertEquals(0, charCount);
    }

    @Test
    void characterCountInStringTest4() {
        Question3 question3 = new Question3();
        int charCount = question3.characterCountInString("cascade",'C');
        Assertions.assertEquals(0, charCount);
    }
}