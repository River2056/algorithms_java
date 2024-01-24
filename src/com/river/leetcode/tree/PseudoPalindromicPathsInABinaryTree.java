package com.river.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {

    private int odd = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        return dfs(root, map);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return 0;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        int oddChange = map.getOrDefault(node.val, 0) % 2 == 1 ? 1 : -1;
        odd += oddChange;

        int res = 0;
        if (node != null && node.left == null && node.right == null) {
            res = odd <= 1 ? 1 : 0;
        } else {
            res = dfs(node.left, map) + dfs(node.right, map);
        }
        map.put(node.val, map.getOrDefault(node.val, 0) - 1);
        odd -= oddChange;
        return res;
    }

    private void test() {
        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(3), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1)));
        System.out.println(pseudoPalindromicPaths(root));
    }

    private void test2() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1,
                        new TreeNode(1), new TreeNode(3, null, new TreeNode(1))),
                new TreeNode(1));
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static void main(String[] args) {
        PseudoPalindromicPathsInABinaryTree p = new PseudoPalindromicPathsInABinaryTree();
        p.test();
        p.test2();
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
