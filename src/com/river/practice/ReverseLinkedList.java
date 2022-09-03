package com.river.practice;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    return prev;
  }

  public void test() {
    ListNode list =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    list = reverseList(list);
    printLinkedList(list);
  }

  public void test2() {
    ListNode list = new ListNode(1, new ListNode(2));
    list = reverseList(list);
    printLinkedList(list);
  }

  public void test3() {
    ListNode list = null;
    list = reverseList(list);
    printLinkedList(list);
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
    ReverseLinkedList rl = new ReverseLinkedList();
    rl.test();
    rl.test2();
    rl.test3();
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
