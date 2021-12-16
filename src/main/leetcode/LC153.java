package main.leetcode;

import java.util.Arrays;

public class LC153 {
    public static void main(String[] args) {
        System.out.println(new LC153().findMin(new int[]{
                3, 4, 5, 1, 2
        }));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
