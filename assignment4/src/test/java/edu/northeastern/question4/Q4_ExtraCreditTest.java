package edu.northeastern.question4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Q4_ExtraCreditTest {

    @Test
    void anyPermutation() {
        Q4_ExtraCredit q4_extraCredit = new Q4_ExtraCredit();
        System.out.println(Arrays.toString(q4_extraCredit.anyPermutation("IDID")));
        Assertions.assertArrayEquals(new int[]{2, 3, 1, 4, 0}, q4_extraCredit.anyPermutation("IDID"));
    }
}