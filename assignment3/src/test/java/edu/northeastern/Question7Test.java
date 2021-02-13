package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Question7Test {

    @Test
    void spiralOrderTest1() {
        Question7 question7 = new Question7();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(question7.spiralOrder(matrix)));
        Assertions.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", Arrays.toString(question7.spiralOrder(matrix)));
    }

    @Test
    void spiralOrderTest2() {
        Question7 question7 = new Question7();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(question7.spiralOrder(matrix)));
        Assertions.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", Arrays.toString(question7.spiralOrder(matrix)));
    }

    @Test
    void spiralOrderTest3() {
        Question7 question7 = new Question7();
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        System.out.println(Arrays.toString(question7.spiralOrder(matrix)));
        Assertions.assertEquals("[1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]", Arrays.toString(question7.spiralOrder(matrix)));
    }
}