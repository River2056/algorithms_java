package com.river.datastructure;

public class BinarySearchTree {

  private int size;
  private TreeNode<Integer> root;

  public int length() {
    return this.size;
  }

  public TreeNode<Integer> insert(Integer value) {
    TreeNode<Integer> node = new TreeNode<>(value);

    if (this.root == null) {
      this.root = node;
      return node;
    }

    TreeNode<Integer> current = this.root;
    while (true) {
      if (current.getValue() < node.getValue()) {
        if (current.getRightChild() == null) {
          current.setRightChild(node);
          this.size++;
          return node;
        }
        current = current.getRightChild();
      } else {
        if (current.getLeftChild() == null) {
          current.setLeftChild(node);
          this.size++;
          return node;
        }
        current = current.getLeftChild();
      }
    }
  }

  public String printBST() {
    return this.root == null ? null : this.root.toString();
  }
}
