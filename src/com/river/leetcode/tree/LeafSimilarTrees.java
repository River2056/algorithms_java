package com.river.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.river.leetcode.tree.model.TreeNode;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        dfs(left, root1);
        dfs(right, root2);
        return left.equals(right);
    }

    private void dfs(List<Integer> leafData, TreeNode node) {
        if (node == null)
            return;
        if (node != null && node.left == null && node.right == null) {
            leafData.add(node.val);
            return;
        }
        dfs(leafData, node.left);
        dfs(leafData, node.right);
    }

    private void test() {
        System.out.println("test");
        TreeNode leftTree = new TreeNode(
            3, 
            new TreeNode(5, 
                new TreeNode(6), 
                new TreeNode(2, 
                    new TreeNode(7), 
                    new TreeNode(4))),
            new TreeNode(1, 
                new TreeNode(9), 
                new TreeNode(8)));

        TreeNode rightTree = new TreeNode(
                3,
                new TreeNode(5, 
                    new TreeNode(6),
                    new TreeNode(7)), 
                new TreeNode(1, 
                    new TreeNode(4),
                    new TreeNode(2, 
                        new TreeNode(9),
                        new TreeNode(8))));

        LeafSimilarTrees l = new LeafSimilarTrees();
        System.out.println(l.leafSimilar(leftTree, rightTree)); // true
    }

    private void test2() {
        System.out.println("test2");
        TreeNode leftTree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode rightTree = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        LeafSimilarTrees l = new LeafSimilarTrees();
        System.out.println(l.leafSimilar(leftTree, rightTree)); // false
    }

    private void test3() {
        System.out.println("test3");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 5, 4);
        System.out.println(list.equals(list2));
    }

    public static void main(String[] args) {
        LeafSimilarTrees l = new LeafSimilarTrees();
        l.test();
        l.test2();
        l.test3();
    }
}
