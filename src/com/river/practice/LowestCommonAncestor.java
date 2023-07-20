package com.river.practice;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null)
            return right;
        else
            return left;
    }

    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode ans = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(ans); // 6
    }

    public void test2() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode ans = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(ans); // 2
    }

    public void test3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode ans = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1));
        System.out.println(ans); // 2
    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        l.test();
        l.test2();
        l.test3();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return String.format("TreeNode[val: %s]", this.val);
    }
}
