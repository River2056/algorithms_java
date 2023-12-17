package com.river.leetcode.linkedlist;

public class LinkedlistCycleII {
  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return null;

    ListNode slow = head, fast = head;
    while (true) {
      if (fast == null || fast.next == null) return null;
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
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

    ListNode detect = detectCycle(a);
    System.out.printf("1. %s\n", detect == null ? null : detect.val);
  }

  private void test2() {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    a.next = b;
    b.next = a;

    ListNode detect = detectCycle(a);
    System.out.printf("2. %s\n", detect == null ? null : detect.val);
  }

  private void test3() {
    ListNode a = new ListNode(1);

    ListNode detect = detectCycle(a);
    System.out.printf("3. %s\n", detect == null ? null : detect.val);
  }

  private void test4() {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    a.next = b;

    ListNode detect = detectCycle(a);
    System.out.printf("4. %s\n", detect == null ? null : detect.val);
  }

  public static void main(String[] args) {
    LinkedlistCycleII cycle = new LinkedlistCycleII();
    cycle.test();
    cycle.test2();
    cycle.test3();
    cycle.test4();
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
