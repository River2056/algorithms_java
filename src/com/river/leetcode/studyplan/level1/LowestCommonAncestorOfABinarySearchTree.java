package com.river.leetcode.studyplan.level1;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val)
                cur = cur.right;
            else if (p.val < cur.val && q.val < cur.val)
                cur = cur.left;
            else
                return cur;
        }

        return null;
    }

    private void test() {
        TreeNode a = new TreeNode(6);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(0);
        a.left.right = new TreeNode(4);
        a.left.right.left = new TreeNode(3);
        a.left.right.right = new TreeNode(5);

        a.right = new TreeNode(8);
        a.right.left = new TreeNode(7);
        a.right.right = new TreeNode(9);

        TreeNode res = lowestCommonAncestor(a, new TreeNode(2), new TreeNode(8));
        System.out.printf("1. %s\n", res.val); // 6
    }

    private void test2() {
        TreeNode a = new TreeNode(6);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(0);
        a.left.right = new TreeNode(4);
        a.left.right.left = new TreeNode(3);
        a.left.right.right = new TreeNode(5);

        a.right = new TreeNode(8);
        a.right.left = new TreeNode(7);
        a.right.right = new TreeNode(9);

        TreeNode res = lowestCommonAncestor(a, new TreeNode(2), new TreeNode(4));
        System.out.printf("2. %s\n", res.val); // 2
    }

    private void test3() {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);

        TreeNode res = lowestCommonAncestor(a, new TreeNode(2), new TreeNode(1));
        System.out.printf("3. %s\n", res.val); // 2
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree low = new LowestCommonAncestorOfABinarySearchTree();
        low.test();
        low.test2();
        low.test3();
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
