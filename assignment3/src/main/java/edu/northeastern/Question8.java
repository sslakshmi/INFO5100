package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class Question8 {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * String convert(string s, int numRows);
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * <p>
     * Example 2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param input
     * @return
     */
    public String convert(String input, int numRows) {

        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }
        int index = 0;
        char temp;
        while (index < input.toCharArray().length) {
            for (int i = 0; i < numRows; i++) {
                if (index < input.toCharArray().length) {
                    temp = input.charAt(index);
                    result.get(i).add(temp);
                    index++;
                } else {
                    break;
                }
            }
            for (int i = numRows - 2; i > 0; i--) {
                if (index < input.toCharArray().length) {
                    temp = input.charAt(index);
                    result.get(i).add(temp);
                    index++;
                } else {
                    break;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        for (List<Character> item : result) {
            for (Character ch : item) {
                output.append(ch);
            }
        }
        return output.toString();
    }
}
