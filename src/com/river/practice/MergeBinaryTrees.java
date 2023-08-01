package com.river.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

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

    public BinaryTree mergeBinaryTreesSelf(BinaryTree tree1, BinaryTree tree2) {
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

    public BinaryTree mergeBinaryTreesRecursive(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null)
            return tree2;
        if (tree2 == null)
            return tree1;

        tree1.value += tree2.value;
        tree1.left = mergeBinaryTreesRecursive(tree1.left, tree2.left);
        tree1.right = mergeBinaryTreesRecursive(tree1.right, tree2.right);
        return tree1;
    }

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null)
            return tree2;

        Deque<Optional<BinaryTree>> tree1Stack = new ArrayDeque<>();
        tree1Stack.add(Optional.ofNullable(tree1));
        Deque<Optional<BinaryTree>> tree2Stack = new ArrayDeque<>();
        tree2Stack.add(Optional.ofNullable(tree2));

        while (!tree1Stack.isEmpty()) {
            BinaryTree tree1Node = tree1Stack.removeLast().orElse(null);
            BinaryTree tree2Node = tree2Stack.removeLast().orElse(null);

            if (tree2Node == null)
                continue;

            tree1Node.value += tree2Node.value;
            if (tree1Node.left == null)
                tree1Node.left = tree2Node.left;
            else {
                tree1Stack.add(Optional.ofNullable(tree1Node.left));
                tree2Stack.add(Optional.ofNullable(tree2Node.left));
            }

            if (tree1Node.right == null)
                tree1Node.right = tree2Node.right;
            else {
                tree1Stack.add(Optional.ofNullable(tree1Node.right));
                tree2Stack.add(Optional.ofNullable(tree2Node.right));
            }
        }

        return tree1;
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
