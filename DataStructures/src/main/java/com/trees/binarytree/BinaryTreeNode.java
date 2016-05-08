package com.trees.binarytree;

/**
 * Created by Kunal on 3/22/2016.
 */
public class BinaryTreeNode {

    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int data;

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
