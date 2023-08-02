package com.river.algo_expert.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * SymmetricalTree
 */
public class SymmetricalTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean symmetricalTree(BinaryTree tree) {
        List<Integer> subtreeLeft = new ArrayList<>();
        List<Integer> subtreeRight = new ArrayList<>();
        traverseLeftDfs(tree.left, subtreeLeft);
        traverseRightDfs(tree.right, subtreeRight);
        return subtreeLeft.equals(subtreeRight);
    }

    private void traverseLeftDfs(BinaryTree node, List<Integer> res) {
        if (node == null)
            return;
        traverseLeftDfs(node.left, res);
        res.add(node.value);
        traverseLeftDfs(node.right, res);
    }

    private void traverseRightDfs(BinaryTree node, List<Integer> res) {
        if (node == null)
            return;
        traverseRightDfs(node.right, res);
        res.add(node.value);
        traverseRightDfs(node.left, res);
    }

    public static void main(String[] args) {
        BinaryTree a = new BinaryTree(1);
        a.left = new BinaryTree(2);
        a.right = new BinaryTree(2);

        a.left.left = new BinaryTree(3);
        a.left.right = new BinaryTree(4);
        a.left.left.left = new BinaryTree(5);
        a.left.left.right = new BinaryTree(6);

        a.right.left = new BinaryTree(4);
        a.right.right = new BinaryTree(3);
        a.right.right.left = new BinaryTree(6);
        a.right.right.right = new BinaryTree(5);
    }
}
