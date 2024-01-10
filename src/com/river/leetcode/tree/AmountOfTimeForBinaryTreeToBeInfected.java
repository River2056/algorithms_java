package com.river.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        int result = 0;
        Map<Integer, List<Integer>> adjencencyList = new HashMap<>();
        dfs(root, adjencencyList, null);

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> infected = new HashSet<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer level = queue.size();
            while (level > 0) {
                Integer node = queue.poll();
                level--;
                infected.add(node);
                List<Integer> children = adjencencyList.get(node);
                if (!children.isEmpty()) {
                    for (Integer child : children) {
                        if (!infected.contains(child)) {
                            queue.add(child);
                        }
                    }
                }
            }
            result++;
        }

        return result - 1;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> adjencencyList, Integer parent) {
        if (root == null)
            return;

        if (!adjencencyList.containsKey(root.val)) {
            List<Integer> children = new ArrayList<>();
            if (root.left != null)
                children.add(root.left.val);
            if (root.right != null)
                children.add(root.right.val);
            if (parent != null)
                children.add(parent);
            adjencencyList.put(root.val, children);
        }

        dfs(root.left, adjencencyList, root.val);
        dfs(root.right, adjencencyList, root.val);
    }

    private void test() {
        TreeNode root = new TreeNode(1,
                new TreeNode(5, null, new TreeNode(4,
                        new TreeNode(9),
                        new TreeNode(2))),
                new TreeNode(3,
                        new TreeNode(10),
                        new TreeNode(6)));
        System.out.println(amountOfTime(root, 3)); // 4
    }

    private void test2() {
        TreeNode root = new TreeNode(1);
        System.out.println(amountOfTime(root, 1)); // 0
    }

    public static void main(String[] args) {
        AmountOfTimeForBinaryTreeToBeInfected a = new AmountOfTimeForBinaryTreeToBeInfected();
        a.test();
        a.test2();
    }
}
