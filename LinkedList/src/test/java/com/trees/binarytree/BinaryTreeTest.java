package com.trees.binarytree;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kunal on 3/22/2016.
 */
public class BinaryTreeTest {
    BinaryTreeNode root = new BinaryTreeNode();
    @Before
    public void setup() {
        BinaryTreeNode left1 = new BinaryTreeNode();
        BinaryTreeNode right2 = new BinaryTreeNode();
        BinaryTreeNode left11 = new BinaryTreeNode();
        BinaryTreeNode right12 = new BinaryTreeNode();
        BinaryTreeNode left21 = new BinaryTreeNode();
        BinaryTreeNode right22 = new BinaryTreeNode();
        root.setData(1);
        left1.setData(2);
        right2.setData(3);
        left11.setData(4);
        right12.setData(5);
        left21.setData(6);
        right22.setData(7);

        root.setLeft(left1);
        root.setRight(right2);

        left1.setLeft(left11);
        left1.setRight(right12);

        right2.setLeft(left21);
        right2.setRight(right22);
    }

    @Test
    public void PreOrderTest() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrder(root);
    }

    @Test
    public void InOrderTest() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.inOrder(root);
    }

    @Test
    public void PostOrderTest() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.postOrder(root);
    }
}