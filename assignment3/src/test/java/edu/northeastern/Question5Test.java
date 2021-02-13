package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question5Test {

    @Test
    void countAndSayTest1() {
        Question5 question5 = new Question5();
        System.out.println(question5.countAndSay(1));
        Assertions.assertEquals("1",question5.countAndSay(1));
    }

    @Test
    void countAndSayTest2() {
        Question5 question5 = new Question5();
        System.out.println(question5.countAndSay(2));
        Assertions.assertEquals("11",question5.countAndSay(2));
    }

    @Test
    void countAndSayTest3() {
        Question5 question5 = new Question5();
        System.out.println(question5.countAndSay(3));
        Assertions.assertEquals("21",question5.countAndSay(3));
    }

    @Test
    void countAndSayTest4() {
        Question5 question5 = new Question5();
        System.out.println(question5.countAndSay(4));
        Assertions.assertEquals("1211",question5.countAndSay(4));
    }

    @Test
    void countAndSayTest5() {
        Question5 question5 = new Question5();
        System.out.println(question5.countAndSay(5));
        Assertions.assertEquals("111221",question5.countAndSay(5));
    }
}