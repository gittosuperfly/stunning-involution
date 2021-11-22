package main.leetcode.help;

public class Printer {

    public static void print(ListNode link) {
        ListNode node = link;
        if (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        while (node != null) {
            System.out.print(" -> " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void print(int[] nums) {
        System.out.print(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            System.out.print(" -> " + nums[i]);
        }
    }

}
