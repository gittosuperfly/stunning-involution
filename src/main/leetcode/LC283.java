package main.leetcode;

import main.leetcode.help.Printer;

public class LC283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1};
        moveZeroes(nums);
        Printer.print(nums);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (nums[left] == 0) {
                    swap(nums, left, right);
                }
                left++;
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
