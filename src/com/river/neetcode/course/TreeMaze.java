package com.river.neetcode.course;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeMaze
 */
public class TreeMaze {

    public List<List<Integer>> findPath(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, temp, results);
        return results;
    }

    private void dfs(Node node, List<Integer> temp, List<List<Integer>> results) {
        if (node == null || node.val == 0)
            return;

        if (node.val != 0 && node.left == null && node.right == null) {
            temp.add(node.val);
            List<Integer> path = new ArrayList<>(temp);
            results.add(path);
            temp.remove(temp.size() - 1);
            return;
        }

        temp.add(node.val);
        dfs(node.left, temp, results);
        dfs(node.right, temp, results);
    }

    private void test() {
        Node root = new Node(4,
                new Node(0, null, new Node(7)),
                new Node(1, new Node(2), new Node(0)));
        System.out.println(findPath(root));
    }

    public static void main(String[] args) {
        TreeMaze t = new TreeMaze();
        t.test();
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
