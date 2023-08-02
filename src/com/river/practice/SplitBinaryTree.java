package com.river.practice;

/**
 * SplitBinaryTree
 */
public class SplitBinaryTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int splitBinaryTree(BinaryTree tree) {
        int total = postOrder(tree, Integer.MAX_VALUE);
        if (total % 2 != 0)
            return 0;

        int target = total / 2;
        return postOrder(tree, target) == target ? target : 0;
    }

    private int postOrder(BinaryTree node, int target) {
        if (node == null)
            return 0;

        int left = postOrder(node.left, target);
        int right = postOrder(node.right, target);
        if (left == target || right == target)
            return target;

        return node.value + left + right;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(-2);

        tree.left.left = new BinaryTree(6);
        tree.left.right = new BinaryTree(-5);
        tree.left.left.left = new BinaryTree(2);

        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(2);

        SplitBinaryTree split = new SplitBinaryTree();
        System.out.printf("res: %s%n", split.splitBinaryTree(tree));
    }
}
