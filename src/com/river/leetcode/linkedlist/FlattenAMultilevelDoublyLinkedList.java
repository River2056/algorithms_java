package com.river.leetcode.linkedlist;

public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node pre = null;
        while (head != null) {
            pre = head;
            if (head.child != null) {
                Node tail = dfs(head.child);
                tail.next = head.next;
                if (head.next != null)
                    head.next.prev = tail;

                head.next = head.child;
                head.child.prev = head;
                head.child = null;

                head = tail.next;
                pre = tail;

            } else {
                head = head.next;
            }
        }
        return pre;
    }

    public Node flattenSelfImplement(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node originalNext = cur.next;
                Node child = cur.child;
                cur.next = child;
                child.prev = cur;
                cur.child = null;

                Node childHead = child;
                while (childHead.next != null)
                    childHead = childHead.next;

                // reached child last node
                childHead.next = originalNext;
                if (originalNext != null)
                    originalNext.prev = childHead;
            }
            cur = cur.next;
        }

        return head;
    }

    private void test() {
        Node a = new Node(1, null, null, null);
        Node b = new Node(2, null, null, null);
        Node c = new Node(3, null, null, null);
        Node d = new Node(4, null, null, null);
        Node e = new Node(5, null, null, null);
        Node f = new Node(6, null, null, null);
        Node g = new Node(7, null, null, null);
        Node h = new Node(8, null, null, null);
        Node i = new Node(9, null, null, null);
        Node j = new Node(10, null, null, null);
        Node k = new Node(11, null, null, null);
        Node l = new Node(12, null, null, null);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        e.prev = f;
        f.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;

        g.next = h;
        h.next = i;
        i.next = j;
        j.prev = i;
        i.prev = h;
        h.prev = g;
        c.child = g;

        k.next = l;
        l.prev = k;
        h.child = k;

        a = flatten(a);
        printLinkedlist(a);
    }

    private void test2() {
        Node a = new Node(1, null, null, null);
        Node b = new Node(2, null, null, null);
        Node c = new Node(3, null, null, null);

        a.next = b;
        a.child = c;

        a = flatten(a);
        printLinkedlist(a);
    }

    private void test3() {
        Node a = flatten(null);
        printLinkedlist(a);
    }

    private void test4() {
        Node a = new Node(1, null, null, null);
        Node b = new Node(2, null, null, null);
        Node c = new Node(3, null, null, null);

        a.child = b;
        b.child = c;

        a = flatten(a);
        printLinkedlist(a);
    }

    private void printLinkedlist(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%s\t", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FlattenAMultilevelDoublyLinkedList flat = new FlattenAMultilevelDoublyLinkedList();
        flat.test();
        flat.test2();
        flat.test3();
        flat.test4();
    }
}


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
