package main.sort;

import main.leetcode.help.Printer;

public class MergeSort  {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 6, 8, 4, 9, 0, 10, 1};
        sort(nums);
        Printer.print(nums);
    }

    //这里统一创建了一个帮助数组help。优点是避免了频繁创建数组，缺点是占空间

    public static void sort(int[] nums) {
//        sort(nums, 0, nums.length - 1, new int[nums.length]);
        sortBottomToUp(nums, new int[nums.length]);
    }

    /**
     * 自底向上的归并排序
     * 不需要递归
     */

    private static void sort(int[] nums, int l, int r, int[] help) {
        if (r <= l) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, help);
        sort(nums, mid + 1, r, help);
        merge(nums, l, mid, r, help);
    }

    private static void sortBottomToUp(int[] nums, int[] help) {
        for (int i = 1; i < nums.length; i *= 2) {
            for (int j = 0; j < nums.length - i; j += 2 * i) {
                int mid = i + j - 1;
                if (nums[mid] > (nums[i + j])) {
                    merge(nums, j, mid, Math.min(mid + i, nums.length - 1), help);
                }
            }
        }
    }

    private static void merge(int[] nums, int l, int mid, int r, int[] help) {
        int i = l, j = mid + 1, k;
        //先把原数组放入帮助数组内
        for (k = l; k <= r; k++) {
            help[k] = nums[k];
        }
        //再按大小放回原数组
        k = l;
        //谁小先放谁
        while (i <= mid && j <= r) {
            nums[k++] = help[i] < help[j] ? help[i++] : help[j++];
        }
        //下面两个循环只有一个会执行。放入剩下的元素
        while (i <= mid) {
            nums[k++] = help[i++];
        }
        while (j <= r) {
            nums[k++] = help[j++];
        }
    }

}
