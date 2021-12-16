package main.leetcode;

public class LC221 {

    public static void main(String[] args) {
        System.out.println(new LC221().maximalSquare(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'0', '0', '1', '1', '1'}
                }
        ));
    }

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    max = 1;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] > 0) {
                    if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max * max;
    }
}
