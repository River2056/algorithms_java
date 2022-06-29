package com.river.leetcode.studyplan.level1;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> list, Node node) {
        if (node == null)
            return;

        list.add(node.val);
        if (node.children != null && node.children.size() > 0)
            for (int i = 0; i < node.children.size(); i++)
                dfs(list, node.children.get(i));
    }

    private void test() {
        Node a = new Node(1);

        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        List<Node> childrenA = List.of(c, b, d);
        a.children = childrenA;

        Node e = new Node(5);
        Node f = new Node(6);
        List<Node> childrenC = List.of(e, f);
        c.children = childrenC;
        System.out.printf("1. %s\n", preorder(a));
    }

    private void test2() {
        Node a = new Node(1);

        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(10);

        Node k = new Node(11);
        Node l = new Node(12);
        Node m = new Node(13);
        Node n = new Node(14);

        a.children = List.of(b, c, d, e);
        c.children = List.of(f, g);
        d.children = List.of(h);
        e.children = List.of(i, j);
        g.children = List.of(k);
        h.children = List.of(l);
        k.children = List.of(n);
        i.children = List.of(m);

        System.out.printf("2. %s\n", preorder(a));
    }

    public static void main(String[] args) {
        NaryTreePreorderTraversal nary = new NaryTreePreorderTraversal();
        nary.test();
        nary.test2();
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
