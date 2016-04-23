package com.trees.binarytree;

import com.queue.LLQueue;

/**
 * Created by Kunal on 3/22/2016.
 */
public class BinaryTree {

    void preOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getData());
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
    }

    void inOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeft());
            System.out.println(treeNode.getData());
            inOrder(treeNode.getRight());
        }
    }

    void postOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.getLeft());
            postOrder(treeNode.getRight());
            System.out.println(treeNode.getData());
        }
    }

    void levelOrder(BinaryTreeNode treeNode) {
        BinaryTreeNode temp;
        LLQueue queue = new LLQueue();
        
    }
}
