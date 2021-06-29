package main.leetcode;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j] + val;
                } else if (j == i) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j - 1] + val;
                } else {
                    dp[i & 1][j] = Math.min(dp[(i - 1) & 1][j], dp[(i - 1) & 1][j - 1]) + val;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(dp[(n - 1) & 1][i], result);
        }
        return result;
    }
}

/*

dp[i][j] == min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]

 */