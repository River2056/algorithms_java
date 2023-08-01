package com.river.leetcode.tree;

/**
 * InvertBinaryTree
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        } else if (node.left != null && node.right == null) {
            node.right = node.left;
            node.left = null;
        } else if (node.left == null && node.right != null) {
            node.left = node.right;
            node.right = null;
        }

        invert(node.left);
        invert(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
