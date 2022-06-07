package com.river.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesWithHint(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;
    }

    public ListNode deleteDuplicatesSelf(ListNode head) {
        Set<Integer> hasSeen = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (!hasSeen.contains(cur.val)) {
                if (prev != null)
                    prev.next = cur;
                prev = cur;
                hasSeen.add(cur.val);
                cur = next;
            } else {
                if (prev != null)
                    prev.next = null;
                cur = next;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.printf("%s, \t", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rm = new RemoveDuplicatesFromSortedList();

        ListNode a = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println("list before: ");
        printLinkedList(a);

        ListNode removed = rm.deleteDuplicates(a);
        System.out.println("list after: ");
        printLinkedList(removed);

        a = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println("list before: ");
        printLinkedList(a);

        removed = rm.deleteDuplicates(a);
        System.out.println("list after: ");
        printLinkedList(removed);

        a = new ListNode(1, new ListNode(1, new ListNode(1)));
        System.out.println("list before: ");
        printLinkedList(a);

        removed = rm.deleteDuplicates(a);
        System.out.println("list after: ");
        printLinkedList(removed);

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
