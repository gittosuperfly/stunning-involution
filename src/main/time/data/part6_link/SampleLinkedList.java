package main.time.data.part6_link;

import java.util.LinkedList;
import java.util.List;

public class SampleLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.remove();
    }

    private ListNode mHead;
    private int mSize;

    public SampleLinkedList() {
        mSize = 0;
    }

    public void addFirst(int value) {
        add(value, 0);
    }

    public void add(int value) {
        add(value, mSize);
    }

    public void add(int value, int index) {

    }

    public void remove(int index) {

    }

    public void removeFirst() {

    }

    public void removeLast() {

    }


    private static class ListNode {
        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
