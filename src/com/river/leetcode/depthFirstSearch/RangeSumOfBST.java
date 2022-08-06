package com.river.leetcode.depthFirstSearch;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private Integer dfs(TreeNode node, int low, int high) {
        if (node == null)
            return 0;

        int res = 0;

        if (node.val >= low && node.val <= high)
            res += node.val;

        res += dfs(node.left, low, high);
        res += dfs(node.right, low, high);
        return res;
    }

    public void test() {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null, new TreeNode(18)));
        int result = rangeSumBST(root, 7, 15);
        System.out.printf("1. %s\n", result);
    }

    public void test2() {
        TreeNode root = new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(1), null),
                        new TreeNode(7, new TreeNode(6), null)),
                new TreeNode(15, new TreeNode(13), new TreeNode(18)));
        int result = rangeSumBST(root, 6, 10);
        System.out.printf("2. %s\n", result);
    }

    public static void main(String[] args) {
        RangeSumOfBST r = new RangeSumOfBST();
        r.test();
        r.test2();
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
