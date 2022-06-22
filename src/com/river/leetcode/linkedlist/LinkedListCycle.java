package com.river.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public boolean hasCycleUseSet(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur))
                return true;
            set.add(cur);
            cur = cur.next;
        }

        return false;
    }

    private void test() {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        boolean hasCycle = hasCycle(a);
        System.out.printf("1. res: %s\n", hasCycle);
    }

    private void test2() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        boolean hasCycle = hasCycle(a);
        System.out.printf("2. res: %s\n", hasCycle);
    }

    private void test3() {
        ListNode a = new ListNode(1);

        boolean hasCycle = hasCycle(a);
        System.out.printf("3. res: %s\n", hasCycle);
    }

    private void test4() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        boolean hasCycle = hasCycle(a);
        System.out.printf("4. res: %s\n", hasCycle);
    }

    public static void main(String[] args) {
        LinkedListCycle link = new LinkedListCycle();
        link.test();
        link.test2();
        link.test3();
        link.test4();
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}
