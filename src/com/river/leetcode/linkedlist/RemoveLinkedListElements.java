package com.river.leetcode.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val)
                prev.next = next;
            else
                prev = cur;

            cur = next;
        }

        return dummy.next;
    }

    public void test() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(6,
                new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        a = removeElements(a, 6);
        printLinkedList(a);
    }

    public void test2() {
        ListNode a = new ListNode();
        a = removeElements(a, 1);
        printLinkedList(a);
    }

    public void test3() {
        ListNode a = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        a = removeElements(a, 7);
        printLinkedList(a);
    }


    private void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.printf("%s\t", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveLinkedListElements rm = new RemoveLinkedListElements();
        rm.test();
        rm.test2();
        rm.test3();
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
