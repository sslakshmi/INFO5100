package edu.northeastern.partD;

public class ClosestToTarget {
    public int closestToTarget(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int minDifference = Math.abs(arr[0] - target);
        int minDifferenceIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - target) <= minDifference){
                minDifference = Math.abs(arr[i] - target);
                minDifferenceIndex = i;
            }
        }
        return minDifferenceIndex;
    }

    public static void main(String[] args) {
        ClosestToTarget closestToTarget = new ClosestToTarget();
        int[] arr = new int[]{1,3,3,4};
        int target = closestToTarget.closestToTarget(arr,8);
        System.out.println(target);
        arr = new int[]{1,3,-5,4};
        target = closestToTarget.closestToTarget(arr,-2);
        System.out.println(target);
    }
}
