package com.river;

import com.river.datastructure.BinarySearchTree;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(20);
        tree.insert(15);
        tree.insert(170);

        String jsonResult = tree.printBST();
        System.out.println(jsonResult);
    }
}
