package com.river.leetcode.studyplan.level1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }

    private void test() {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;

        c.left = d;
        c.right = e;

        System.out.printf("1. %s\n", levelOrder(a));
    }

    private void test2() {
        TreeNode a = new TreeNode(1);
        System.out.printf("2. %s\n", levelOrder(a));
    }

    private void test3() {
        System.out.printf("3. %s\n", levelOrder(null));
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal bin = new BinaryTreeLevelOrderTraversal();
        bin.test();
        bin.test2();
        bin.test3();
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
