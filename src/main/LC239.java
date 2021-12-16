package main;

import main.leetcode.help.Printer;

import java.util.PriorityQueue;

public class LC239 {
    public static void main(String[] args) {
        Printer.print(new LC239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        result[0] = queue.peek();

        for (int i = k, index = 1; i < nums.length; i++, index++) {
            queue.remove(nums[index - 1]);
            queue.add(nums[i]);
            result[index] = queue.peek();
        }
        return result;
    }
}
