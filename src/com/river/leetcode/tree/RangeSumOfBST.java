package com.river.leetcode.tree;

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

public class RangeSumOfBST {

    private Integer sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (node == null)
            return;
        if (node.val >= low && node.val <= high)
            sum += node.val;

        dfs(node.left, low, high);
        dfs(node.right, low, high);
    }

    public void test() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        root.right = new TreeNode(15, null, new TreeNode(18));

        RangeSumOfBST r = new RangeSumOfBST();
        System.out.println(r.rangeSumBST(root, 7, 15)); // 32
    }

    public void test2() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null));
        root.right = new TreeNode(15, new TreeNode(13), new TreeNode(18));

        RangeSumOfBST r = new RangeSumOfBST();
        System.out.println(r.rangeSumBST(root, 6, 10)); // 23

    }

    public static void main(String[] args) {
        RangeSumOfBST r = new RangeSumOfBST();
        r.test();
        r.test2();
    }
}
