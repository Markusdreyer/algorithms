package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BinaryTreeLeftMaxDelete searchTree = new BinaryTreeLeftMaxDelete();

        searchTree.put(1, 1);
        searchTree.put(2, 2);
        searchTree.put(3, 3);
        searchTree.put(5, 5);
        searchTree.put(80, 80);
        searchTree.put(70, 70);
        searchTree.put(90, 90);


        System.out.println("Size: " + searchTree.size());
        System.out.println("Max depth: " + searchTree.getMaxTreeDepth());
        searchTree.delete(80);
    }
}
