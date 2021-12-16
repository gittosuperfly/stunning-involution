package main.leetcode;

public class LC494 {

    public static void main(String[] args) {
        System.out.println(new LC494().findTargetSumWays(
                new int[]{
                        1, 1, 1, 1, 1
                }, 3
        ));
    }

    private int result = 0;

    /**
     * dfs做法
     */
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return result;
    }

    private void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length - 1) {
            if (sum + nums[index] == target) {
                result++;
            }
            if (sum - nums[index] == target) {
                result++;
            }
            return;
        }
        dfs(nums, target, index + 1, sum + nums[index]);
        dfs(nums, target, index + 1, sum - nums[index]);
    }

    /**
     * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
     * 所以题目可以转化为
     * sum(P) - sum(N) = target
     * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
     * => 2 * sum(P) = target + sum(nums)
     * => sum(P) = (target + sum(nums)) / 2
     * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
     */
    public static int findTargetSumWaysDp(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }
}
