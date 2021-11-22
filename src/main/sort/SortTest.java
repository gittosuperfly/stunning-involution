package main.sort;

import main.leetcode.help.Printer;

public class SortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 3, 8, 9, 0, 1, 7, 4, 5};
        MergeSort.sort(nums);
        Printer.print(nums);
    }

}

