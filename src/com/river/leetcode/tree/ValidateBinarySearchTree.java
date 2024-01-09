package com.river.leetcode.tree;

import com.river.leetcode.tree.model.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return checkTree(root, null, null);
    }

    private boolean checkTree(TreeNode node, Integer upperLimit, Integer lowerLimit) {
        if (node == null)
            return true;

        if (node != null
                && ((lowerLimit != null && node.val <= lowerLimit)
                        || (upperLimit != null && node.val >= upperLimit)))
            return false;

        return checkTree(node.left, node.val, lowerLimit)
                && checkTree(node.right, upperLimit, node.val);
    }

    private void test() {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(3);

        boolean isValid = isValidBST(a);
        System.out.printf("1. %s\n", isValid);
    }

    private void test2() {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(1);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(3);
        b.right = new TreeNode(6);

        a.right = b;

        boolean isValid = isValidBST(a);
        System.out.printf("2. %s\n", isValid);
    }

    private void test3() {
        TreeNode a = new TreeNode(0);
        a.left = new TreeNode(-1);

        boolean isValid = isValidBST(a);
        System.out.printf("3. %s\n", isValid);
    }

    private void test4() {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(4);
        a.right = new TreeNode(6);
        a.right.left = new TreeNode(3);
        a.right.right = new TreeNode(7);

        boolean isValid = isValidBST(a);
        System.out.printf("4. %s\n", isValid);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree valid = new ValidateBinarySearchTree();
        valid.test();
        valid.test2();
        valid.test3();
        valid.test4();
    }
}
