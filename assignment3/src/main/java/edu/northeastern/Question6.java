package edu.northeastern;

import java.util.Stack;

public class Question6 {
    /**
     * Given an input string , reverse the string word by word.
     * Example:
     * Input : “the sky is blue”
     * Output : “blue is sky the”
     * Assumptions:
     * A word is defined as a sequence of non-space characters.
     * The input string does not contain leading or trailing spaces.
     * The words are always separated by a single space.
     *
     * @param input - String
     * @return - String
     */
    public String reverseStringWordByWord(String input) {
        Stack<String> inputStack = new Stack<>();
        StringBuilder output = new StringBuilder();
        //Split using space, the words in the input string
        //words are added to the String[] words
        String[] words = input.split(" ");
        //Add the words one by one to the stack
        for (int i = 0; i < words.length; i++) {
            inputStack.push(words[i]);
        }
        //Append each popped word from stack to the StringBuilder output
        while (!inputStack.isEmpty()) {
            output.append(inputStack.pop());
            output.append(" ");
        }
        return output.toString().trim();
    }
}
