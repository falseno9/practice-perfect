package com.trees.binarytree;

import java.util.ArrayList;
import java.util.Stack;

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

    ArrayList<Integer> preOrderIterative(BinaryTreeNode treeNode) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (treeNode == null) {
            return res;
        }
        s.push(treeNode);

        while (!s.isEmpty()) {
            BinaryTreeNode tmp = s.pop();
            res.add(tmp.getData());
            if (tmp.getRight() != null) {
                s.push(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                s.push(tmp.getLeft());
            }
        }
        return res;
    }

    void inOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeft());
            System.out.println(treeNode.getData());
            inOrder(treeNode.getRight());
        }
    }

    ArrayList<Integer> inOrderIterative(BinaryTreeNode treeNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = treeNode;
        boolean done = false;
        if (!done) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                if (s.isEmpty()) {
                    done = true;
                } else {
                    currentNode = s.pop();
                    res.add(currentNode.getData());
                    currentNode = currentNode.getRight();
                }
            }
        }
        return res;
    }

    void postOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.getLeft());
            postOrder(treeNode.getRight());
            System.out.println(treeNode.getData());
        }
    }

    int findMax(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = findMax(root.getLeft());
            int rightMax = findMax(root.getRight());

            if (leftMax > rightMax) {
                max = leftMax;
            } else {
                max = rightMax;
            }

            if (root.getData() > max) {
                max = root.getData();
            }
        }
        return max;
    }

    boolean findInBT(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            return true;
        }
        return findInBT(root.getLeft(), data) || findInBT(root.getRight(), data);
    }
}
