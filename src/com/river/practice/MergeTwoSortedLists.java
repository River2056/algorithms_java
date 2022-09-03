package com.river.practice;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode p1 = list1;
    ListNode p2 = list2;
    if (p1 == null && p2 == null) return null;

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        cur.next = p1;
        p1 = p1.next;
      } else if (p1.val > p2.val) {
        cur.next = p2;
        p2 = p2.next;
      }
      cur = cur.next;
    }

    while (p1 != null) {
      cur.next = p1;
      p1 = p1.next;
      cur = cur.next;
    }

    while (p2 != null) {
      cur.next = p2;
      p2 = p2.next;
      cur = cur.next;
    }

    return dummy.next;
  }

  public void test() {
    ListNode a = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));

    ListNode merged = mergeTwoLists(a, b);
    printLinkedlist(merged);
  }

  public void test2() {
    ListNode a = null;
    ListNode b = null;

    ListNode merged = mergeTwoLists(a, b);
    printLinkedlist(merged);
  }

  public void test3() {
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
    MergeTwoSortedLists m = new MergeTwoSortedLists();
    m.test();
    m.test2();
    m.test3();
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
