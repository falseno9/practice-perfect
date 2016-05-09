package com.trees.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kunal on 3/22/2016.
 */
public class BinaryTreeTest {
    BinaryTree binaryTree;
    BinaryTreeNode root = new BinaryTreeNode();
    @Before
    public void setup() {
        binaryTree = new BinaryTree();
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
        binaryTree.preOrder(root);
    }

    @Test
    public void InOrderTest() {
        binaryTree.inOrder(root);
    }

    @Test
    public void PostOrderTest() {
        binaryTree.postOrder(root);
    }

    @Test
    public void findMaxTest() {
        Assert.assertEquals(7, binaryTree.findMax(root));
    }

    @Test
    public void existsInBTTestTrue() {
        Assert.assertEquals(true, binaryTree.findInBT(root, 7));
    }

    @Test
    public void existsInBTTestFalse() {
        Assert.assertEquals(false, binaryTree.findInBT(root, 71));
    }

    @Test
    public void existsInBTTestNull() {
        Assert.assertEquals(false, binaryTree.findInBT(null, 7));
    }

    @Test
    public void sizeOfBTTest() {
        Assert.assertEquals(7, binaryTree.sizeOfBT(root));
    }

    @Test
    public void levelOrderTraversalInReverseTest() {
        binaryTree.levelOrderTraversalInReverse(root);
    }

    @Test
    public void leastDepthOfBTTest() {
        Assert.assertEquals(3, binaryTree.leastDepthOfBT(root));
    }

    @Test
    public void binaryTreeLCATestFound() {
        Assert.assertEquals(1, binaryTree.binaryTreeLCA(root, new BinaryTreeNode(7), new BinaryTreeNode(5)).getData());
    }

    @Test
    public void binaryTreeLCATestNotFound() {
        Assert.assertEquals(5, binaryTree.binaryTreeLCA(root, new BinaryTreeNode(10), new BinaryTreeNode(5)).getData());
    }
}
