package com.river.practice;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.next != null && cur.val == cur.next.val)
                prev.next = next;
            else
                prev = cur;

            cur = next;
        }

        return dummy.next;
    }

    public void test() {
        ListNode a = new ListNode(1, new ListNode(1, new ListNode(2)));
        a = deleteDuplicates(a);
        printLinkedList(a);
    }

    public void test2() {
        ListNode a =
                new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        a = deleteDuplicates(a);
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
        RemoveDuplicatesFromSortedList rm = new RemoveDuplicatesFromSortedList();
        rm.test();
        rm.test2();
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
