package main.leetcode;

public class LC209 {
    public static void main(String[] args) {
        System.out.println(new LC209().minSubArrayLen(15, new int[]{
                1, 2, 3, 4, 5
        }));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0, temp = 0, result = Integer.MAX_VALUE;
        while (r < nums.length) {
            temp += nums[r];
            while (temp >= target) {
                result = Math.min(result, r - l + 1);
                temp -= nums[l];
                l++;
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
