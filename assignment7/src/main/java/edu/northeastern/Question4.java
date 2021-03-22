package edu.northeastern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question4 {
    /**
     * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique
     *
     * Example 1:
     *
     *     Input: arr = [1,2,2,1,1,3]
     *     Output: true
     *     Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
     *     No two values have the same number of occurrences.
     *
     *     Example 2:
     *
     *     Input: arr = [1,2]
     *     Output: false
     *     Example 3:
     *
     *     Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
     *     Output: true
     *
     *     Constraints:
     *
     *     1 <= arr.length <= 1000
     *     -1000 <= arr[i] <= 1000
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int key : map.keySet()){
            if(set.contains(map.get(key))) return false;
            else set.add(map.get(key));
        }
        return true;
    }

    public static void main(String[] args) {
        Question4 question4 = new Question4();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(question4.uniqueOccurrences(arr));

        int[] arr1 = new int[]{1,2,2,1,1,3};
        System.out.println(question4.uniqueOccurrences(arr1));
    }
}
