package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Question6Test {

    @org.junit.jupiter.api.Test
    void reverseStringWordByWordTest1() {
        Question6 question6 = new Question6();
        String input = "the sky is blue";
        System.out.print(question6.reverseStringWordByWord(input));
        Assertions.assertEquals("blue is sky the", question6.reverseStringWordByWord(input));
    }

    @Test
    void reverseStringWordByWordTest2() {
        Question6 question6 = new Question6();
        String input = "one";
        System.out.print(question6.reverseStringWordByWord(input));
        Assertions.assertEquals("one", question6.reverseStringWordByWord(input));
    }

    @Test
    void reverseStringWordByWordTest3() {
        Question6 question6 = new Question6();
        String input = "";
        System.out.print(question6.reverseStringWordByWord(input));
        Assertions.assertEquals("", question6.reverseStringWordByWord(input));
    }

    @Test
    void reverseStringWordByWordTest4() {
        Question6 question6 = new Question6();
        String input = "one two three four five six seven eight nine ten";
        System.out.print(question6.reverseStringWordByWord(input));
        Assertions.assertEquals("ten nine eight seven six five four three two one", question6.reverseStringWordByWord(input));
    }
}