package main.leetcode;

public class LC053 {

    // dp
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //由于每一步的值只和前一步有关，所以dp表可以省略为一个值：即add值
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int add = 0;
        for (int num : nums) {
            //如果add已经小于0了，说明之前值已经是负收益了，可以舍弃，从当前值开始继续遍历
            if (add > 0) {
                add += num;
            } else {
                add = num;
            }
            max = Math.max(max, add);
        }
        return max;
    }

}
