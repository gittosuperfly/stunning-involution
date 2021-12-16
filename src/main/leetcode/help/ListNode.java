package main.leetcode.help;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
        this.val = 0;
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}