package com.river.leetcode.linkedlist;

public class MiddleOfTheLinkedlist {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (slow != null) {
      if (fast == null || fast.next == null) return slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private void test() {
    ListNode a =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode middle = middleNode(a);
    printLinkedlist(middle);
  }

  private void test2() {
    ListNode a =
        new ListNode(
            1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    ListNode middle = middleNode(a);
    printLinkedlist(middle);
  }

  private void printLinkedlist(ListNode node) {
    ListNode cur = node;
    while (cur != null) {
      System.out.printf("%s\t", cur.val);
      cur = cur.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MiddleOfTheLinkedlist middle = new MiddleOfTheLinkedlist();
    middle.test();
    middle.test2();
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
