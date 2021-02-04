package edu.northeastern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question2Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    void findMaxAndMinTest1() {
        Question2 question2 = new Question2();
        int[] input = {3, 5, 7, 1, 4, 32, 15};
        question2.findMaxAndMin(input);
        assertEquals("Max is 32 and Min is 1", outContent.toString());
    }

    @Test
    void findMaxAndMinTest2() {
        Question2 question2 = new Question2();
        //Testing on ascending order input
        int[] input = {1, 2, 3, 4, 5, 6};
        question2.findMaxAndMin(input);
        assertEquals("Max is 6 and Min is 1", outContent.toString());
    }

    @Test
    void findMaxAndMinTest3() {
        Question2 question2 = new Question2();
        //Testing on descending order input
        int[] input = {6, 5, 4, 3, 2, 1};
        question2.findMaxAndMin(input);
        assertEquals("Max is 6 and Min is 1", outContent.toString());
    }

    @Test
    void findMaxAndMinTest4() {
        Question2 question2 = new Question2();
        //Testing on duplicate input
        int[] input = {1, 2, 3, 3, 3, 4, 5, 6, 6, 6};
        question2.findMaxAndMin(input);
        assertEquals("Max is 6 and Min is 1", outContent.toString());
    }

    @Test
    void findMaxAndMinTest5() {
        Question2 question2 = new Question2();
        //Testing on duplicate input
        int[] input = {1, 2, 3, 3, -1, 4, 5, 6, 6, -4};
        question2.findMaxAndMin(input);
        assertEquals("Max is 6 and Min is -4", outContent.toString());
    }
}