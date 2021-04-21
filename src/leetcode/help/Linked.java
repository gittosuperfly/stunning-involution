package leetcode.help;

public class Linked {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void lastAdd(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
    }
}
