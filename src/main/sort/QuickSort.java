package main.sort;

import main.leetcode.help.Printer;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 6, 8, 4, 9, 0, 10, 1};
        sort(nums);
        Printer.print(nums);
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int flagIndex = cut(nums, l, r);
        sort(nums, l, flagIndex);
        sort(nums, flagIndex + 1, r);
    }

    /**
     * 切分数组，将数组由基准点切分成两部分，左半边小于基准点，右半边大于基准点
     */
    public static int cut(int[] nums, int left, int right) {
        int flag = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < flag) {
                // j 的初值为 left，先右移，再交换，小于 flag 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 nums[left + 1..j] < flag，并且 nums(j..i) >= flag
        swap(nums, j, left);
        // 交换以后 nums[left..j - 1] < flag, nums[j] = flag, nums[j + 1..right] >= flag
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
