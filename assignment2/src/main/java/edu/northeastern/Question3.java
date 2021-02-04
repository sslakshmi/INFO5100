package edu.northeastern;

public class Question3 {
//    Write a method that takes a String and character as input and find how many characters are in the String
//    Example #1
//    Input : "North", 'r'
//    Output : 1
//    Explanation: "North" has 1 'r'

    public int characterCountInString(String s, char c) {
        int charCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                charCount++;
            }
        }
        return charCount;
    }
}
