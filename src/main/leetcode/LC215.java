package main.leetcode;

import java.util.Random;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        int index = cut(nums, l, r);
        if (index == k) {
            return nums[index];
        } else {
            return index < k ? findKthLargest(nums, index + 1, r, k) : findKthLargest(nums, 0, index, k);
        }
    }

    private int cut(int[] nums, int l, int r) {
        int flag = nums[l];
        int temp = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < flag) {
                temp++;
                swap(nums, i, temp);
            }
        }
        swap(nums, temp, l);
        return temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
