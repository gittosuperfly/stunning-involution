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
    private static int cut(int[] nums, int l, int r) {
        int i = l, j = r + 1, flag = nums[l];
        while (true) {
            //找到左边大于基准点的一个数
            while (nums[++i] < flag) {
                if (i == r) break;
            }
            //找到右边小于基准点的一个数
            while (nums[--j] > flag) {
                if (j == l) break;
            }
            //如果i.j值已经越界了，就说明已经没有需要交换的了
            if (i >= j) {
                break;
            }
            //交换两个点
            swap(nums, i, j);
        }
        //基准点其实一直都在第一位。前面是从++i开始找的，i的位置（l）保持不动。所以上面步骤结束以后和基准点交换一下位置
        swap(nums, l, j);

        //返回基准点在数组中的下标
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
