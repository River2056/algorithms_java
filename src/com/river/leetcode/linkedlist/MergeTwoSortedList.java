package com.river.leetcode.linkedlist;

public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode p1 = list1;
    ListNode p2 = list2;

    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        cur.next = p1;
        p1 = p1.next;
      } else {
        cur.next = p2;
        p2 = p2.next;
      }

      if (cur != null) cur = cur.next;
    }

    while (p1 != null) {
      cur.next = p1;
      p1 = p1.next;
      if (cur != null) cur = cur.next;
    }

    while (p2 != null) {
      cur.next = p2;
      p2 = p2.next;
      if (cur != null) cur = cur.next;
    }

    return dummy.next;
  }

  private void test() {
    ListNode a = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode merged = mergeTwoLists(a, b);
    printLinkedlist(merged);
  }

  private void test2() {
    ListNode merged = mergeTwoLists(null, null);
    printLinkedlist(merged);
  }

  private void test3() {
    ListNode a = null;
    ListNode b = new ListNode(0);
    ListNode merged = mergeTwoLists(a, b);
    printLinkedlist(merged);
  }

  private void printLinkedlist(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
      System.out.printf("%s\t", cur.val);
      cur = cur.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MergeTwoSortedList merge = new MergeTwoSortedList();
    merge.test();
    merge.test2();
    merge.test3();
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
