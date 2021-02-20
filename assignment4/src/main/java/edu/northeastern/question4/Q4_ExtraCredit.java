package edu.northeastern.question4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q4_ExtraCredit {

    public int[] anyPermutation(String input){
        int[] output = new int[input.length() + 1];
        Deque<Integer> order = new LinkedList<Integer>();
        order.addFirst(0);
        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == 'I'){
                order.addLast(index + 1);
            }
            else{
                order.addFirst(index + 1);
            }
        }
        for (int i = 0; i < input.length() + 1; i++) {
            output[order.pollFirst()] = i;
        }
        return output;
    }
}
