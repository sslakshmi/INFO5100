package edu.northeastern;

public class Question3 {


    public static void main(String[] args) {
        Question3 question3 = new Question3();
        System.out.println(question3.isAnagram("anagram", "nagaram"));
    }

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s
     * Example 1:
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * <p>
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     * <p>
     * Note:
     * You may assume the string contains only lowercase alphabets.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int charIndex = t.charAt(i) - 'a';
            charCount[charIndex] -= 1;
            if (charCount[charIndex] < 0) return false;
        }
        return true;
    }
}
