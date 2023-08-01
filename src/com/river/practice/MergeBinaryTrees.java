package com.river.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeBinaryTrees
 */
public class MergeBinaryTrees {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        dfs(tree1, tree2, null, -1);
        return tree1;
    }

    private void dfs(BinaryTree node1, BinaryTree node2, BinaryTree parent, Integer dir) {
        if (node1 == null && node2 == null)
            return;

        if (node1 != null && node2 != null) {
            node1.value += node2.value;
        } else if (node1 == null && node2 != null) {
            if (parent != null) {
                if (dir == 0)
                    parent.left = node2;
                else if (dir == 1)
                    parent.right = node2;
            } else {
                node1 = new BinaryTree(node2.value);
            }
        } else if (node1 != null && node2 == null) {
            if (parent != null) {
                if (dir == 0)
                    parent.left = node1;
                else if (dir == 1)
                    parent.right = node1;
            } else {
                node2 = new BinaryTree(node1.value);
            }
        }

        dfs(node1 == null ? null : node1.left, node2 == null ? null : node2.left, node1, 0);
        dfs(node1 == null ? null : node1.right, node2 == null ? null : node2.right, node1, 1);
    }

    public void printTree(BinaryTree tree, List<Integer> res) {
        if (tree == null)
            return;
        printTree(tree.left, res);
        res.add(tree.value);
        printTree(tree.right, res);
    }

    public static void main(String[] args) {
        MergeBinaryTrees m = new MergeBinaryTrees();
        BinaryTree a = new BinaryTree(1);
        a.left = new BinaryTree(3);
        a.right = new BinaryTree(2);

        a.left.left = new BinaryTree(7);
        a.left.right = new BinaryTree(4);

        BinaryTree b = new BinaryTree(1);
        b.left = new BinaryTree(5);
        b.right = new BinaryTree(9);

        b.left.left = new BinaryTree(2);
        b.right.left = new BinaryTree(7);
        b.right.right = new BinaryTree(6);

        a = m.mergeBinaryTrees(a, b);
        List<Integer> res = new ArrayList<>();
        m.printTree(a, res);
        System.out.println(res);
    }
}
