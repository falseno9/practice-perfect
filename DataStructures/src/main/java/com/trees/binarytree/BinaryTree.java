package com.trees.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTree {

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
            } else {
                if (s.isEmpty()) {
                    done = true;
                } else {
                    currentNode = s.pop();
                    res.add(currentNode.getData());
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
        return root != null && (root.getData() == data || findInBT(root.getLeft(), data) || findInBT(root.getRight(), data));
    }

    int sizeOfBT(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = root.getLeft() == null ? 0 : sizeOfBT(root.getLeft());
        int rightCount = root.getRight() == null ? 0 : sizeOfBT(root.getRight());

        return 1 + leftCount + rightCount;
    }

    void levelOrderTraversalInReverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (tmp.getRight() != null) {
                q.offer(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                q.offer(tmp.getLeft());
            }
            s.push(tmp);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop().getData());
        }
    }

    private int depthOfBT(BinaryTreeNode root) {
        int leftDepth = depthOfBT(root.getLeft());
        int rightDepth = depthOfBT(root.getRight());
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    int leastDepthOfBT(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        int count = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode currentNode = q.poll();
            if (currentNode != null) {
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    return count;
                }
                if (currentNode.getLeft() != null) {
                    q.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    q.offer(currentNode.getRight());
                }
            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                    count++;
                }
            }
        }
        return count;
    }

    BinaryTreeNode binaryTreeLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode left, right;
        if (root == null) {
            return null;
        }
        if (root.equals(a) || root.equals(b)) {
            return root;
        }
        left = binaryTreeLCA(root.getLeft(), a, b);
        right = binaryTreeLCA(root.getRight(), a, b);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    void printLevels(BinaryTreeNode root, int low, int high) {

        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);

        int lvl = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();

            if (tmp == null) {
                System.out.println("");
                lvl++;

                if (lvl > high || q.isEmpty()) {
                    break;
                }

                q.offer(null);
                continue;
            }
            if (lvl >= low) {
                System.out.println(tmp.getData() + " ");
            }
            if (tmp.getLeft() != null) {
                q.add(tmp.getLeft());
            }

            if (tmp.getRight() != null) {
                q.add(tmp.getRight());
            }
        }
    }

}
