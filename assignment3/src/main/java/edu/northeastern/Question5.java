package edu.northeastern;

public class Question5 {

    /**
     * The count-and-say sequence is a sequence of integers with the first five terms as following:
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     *
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
     * Note: Each term of the sequence of integers will be represented as a string.
     *
     * Example 1:
     * Input: 1
     * Output: "1"
     *
     * Example 2:
     * Input: 4
     * Output: "1211"
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String intermediate = "";
        for (int i = 0; i < n; i++) {
            //countAndSay output at each stage is returned and again provided as input for next stage.
            intermediate = countAndSay(intermediate);
        }
        return intermediate;
    }

    //Provide countAndSay result at each stage in loop for the input String intermediate
    private String countAndSay(String intermediate) {
        if(intermediate == "") return "1";
        if(intermediate == "1") return "11";
        String result = "";
        //char num and int eachNumCount are initialized
        char num = intermediate.charAt(0);
        int eachNumCount = 1;
        for (int i = 1; i < intermediate.length(); i++) {
            //Increment the eachNumCount for each occurrence of num
            if(num == intermediate.charAt(i)){
                eachNumCount++;
            }
            else {
                //When a new char for num is encountered -
                // * Append the count and char to the result
                // * Also initialise num and eachNumCount
                result = result + eachNumCount + num;
                num = intermediate.charAt(i);
                eachNumCount = 1;
            }
        }
        //Special case - For last char in num and its count
        result = result + eachNumCount + num;
        return result;
    }


}
