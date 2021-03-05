package edu.northeastern;

public class Question1 {

    public static int getArrayValue(int[] arr, int index) throws MyIndexOutOfBoundException {
        int length = arr.length - 1;
        if(index > length || index < 0) {
            MyIndexOutOfBoundException myIndexOutOfBoundException = new MyIndexOutOfBoundException(0, length, index);
            throw myIndexOutOfBoundException;
        }
        return arr[index];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        try {
            int val = getArrayValue(arr, 10);
        } catch (MyIndexOutOfBoundException e) {
            System.out.println(e);
        }
    }
}
