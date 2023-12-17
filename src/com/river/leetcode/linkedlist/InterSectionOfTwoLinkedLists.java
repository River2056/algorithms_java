package com.river.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    this.val = x;
    this.next = null;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class InterSectionOfTwoLinkedLists {
  public static ListNode getIntersectionNodeHashMap(ListNode headA, ListNode headB) {
    Set<ListNode> set = new HashSet<>();
    ListNode cur = headA;
    while (cur != null) {
      set.add(cur);
      cur = cur.next;
    }

    cur = headB;
    while (cur != null) {
      if (set.contains(cur)) {
        return cur;
      }
      set.add(cur);
      cur = cur.next;
    }

    return null;
  }

  public static ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
    int lengthA = 0;
    int lengthB = 0;
    ListNode cur = headA;
    while (cur != null) {
      lengthA++;
      cur = cur.next;
    }

    cur = headB;
    while (cur != null) {
      lengthB++;
      cur = cur.next;
    }

    ListNode longP, shortP;
    if (lengthA > lengthB) {
      longP = headA;
      shortP = headB;
    } else {
      longP = headB;
      shortP = headA;
    }

    int headStart = Math.abs(lengthA - lengthB);
    while (longP != null) {
      if (headStart <= 0) {
        if (longP == shortP) {
          return longP;
        }
        longP = longP.next;
        shortP = shortP.next;
      } else {
        headStart--;
        longP = longP.next;
      }
    }

    return null;
  }

  public static void test1() {
    ListNode x = new ListNode(2, new ListNode(4));
    ListNode a = new ListNode(1, new ListNode(9, new ListNode(1, x)));
    ListNode b = new ListNode(3, x);
    ListNode res = getIntersectionNodeTwoPointers(a, b);
    if (res != null) System.out.printf("res => val: %s, next: %s\n", res.val, res.next);
    else System.out.println("res is null!");
  }

  public static void main(String[] args) {
    test1();
  }
}
