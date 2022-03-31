package com.river.datastructure;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public TreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public TreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeftChild(TreeNode<T> left) {
        this.leftChild = left;
    }

    public void setRightChild(TreeNode<T> right) {
        this.rightChild = right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
        result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TreeNode<T> other = (TreeNode<T>) obj;
        if (leftChild == null) {
            if (other.leftChild != null)
                return false;
        } else if (!leftChild.equals(other.leftChild))
            return false;
        if (rightChild == null) {
            if (other.rightChild != null)
                return false;
        } else if (!rightChild.equals(other.rightChild))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("{ value: %s, left: %s, right: %s }", this.value, this.leftChild,
                this.rightChild);
    }
}
