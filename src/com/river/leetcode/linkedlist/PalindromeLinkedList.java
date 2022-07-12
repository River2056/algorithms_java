package com.river.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // slow at the end
        slow = prev;
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    // time: O(n), space: O(n) because of temp List
    public boolean isPalindromeSelf(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            temp.add(cur.val);
            cur = cur.next;
        }

        int left = 0, right = temp.size() - 1;
        while (left < right) {
            if (temp.get(left) != temp.get(right))
                return false;
            left++;
            right--;
        }

        return true;
    }

    private void test() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean isListPalindrome = isPalindrome(a);
        System.out.printf("1. %s\n", isListPalindrome);
    }

    private void test2() {
        ListNode a = new ListNode(1, new ListNode(2));
        boolean isListPalindrome = isPalindrome(a);
        System.out.printf("2. %s\n", isListPalindrome);
    }

    public static void main(String[] args) {
        PalindromeLinkedList palin = new PalindromeLinkedList();
        palin.test();
        palin.test2();
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
