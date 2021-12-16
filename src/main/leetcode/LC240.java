package main.leetcode;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0, j = matrix[i].length - 1; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
