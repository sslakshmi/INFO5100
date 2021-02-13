package edu.northeastern;

public class Question7 {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * Example 1:
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * <p>
     * Example 2:
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    //Class properties
    private int leftEdge;
    private int rightEdge;
    private int topEdge;
    private int bottomEdge;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] output = new int[m * n];

        initEdges(m, n);

        int step = 0;
        int currentM = 0;
        int currentN = 0;
        int index = 0;
        while (index < (m * n) - 1) {
            while (hasReachedEdge(step, currentM, currentN)) {
                output[index] = matrix[currentM][currentN];
                index++;
                currentM = getNextM(step, currentM);
                currentN = getNextN(step, currentN);
            }
            updateEdge(step);
            step++;
        }
        output[index] = matrix[currentM][currentN];
        return output;
    }

    private void updateEdge(int step) {
        int operation = step % 4;
        switch (operation) {
            case 0:
                topEdge += 1;
                break;
            case 1:
                rightEdge -= 1;
                break;
            case 2:
                bottomEdge -= 1;
                break;
            case 3:
                leftEdge += 1;
                break;
        }
    }

    private boolean hasReachedEdge(int step, int currentM, int currentN) {
        int operation = step % 4;
        switch (operation) {
            case 0:
                return currentN < rightEdge;
            case 1:
                return currentM < bottomEdge;
            case 2:
                //ASK
                return currentN > leftEdge;
            case 3:
                return currentM > topEdge;
            default:
                return false;
        }
    }

    private int getNextM(int step, int currentM) {
        int operation = step % 4;
        switch (operation) {
            case 0:
                //moving towards right along the top
                return currentM;
            case 1:
                //moving towards bottom along right
                return currentM + 1;
            case 2:
                //moving towards left along the bottom
                return currentM;
            case 3:
                //moving towards up along the left
                return currentM - 1;
            default:
                return 0;
        }
    }

    private int getNextN(int step, int currentN) {
        int operation = step % 4;
        switch (operation) {
            case 0:
                return currentN + 1;
            case 1:
            case 3:
                return currentN;
            case 2:
                return currentN - 1;
            default:
                return 0;
        }
    }

    private void initEdges(int m, int n) {
        leftEdge = 0;
        rightEdge = n - 1;
        topEdge = 0;
        bottomEdge = m - 1;
    }
}
