package com.lists.linkedlist;

/**
 * Created by Kunal on 3/6/2016.
 */
public class DoublyLinkedList {

    public int listLength(DLLNode node) {
        int length = 0;
        if (node != null) {
            do {
                node = node.getNext();
                length++;
            } while (node  != null);
        }
        return length;
    }

    public DLLNode insertNode (DLLNode head, DLLNode nodeToInsert, int position) {

        if (position == 1) {
            nodeToInsert.setNext(head);
            head.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            int curr = 1;
            DLLNode previousNode = head;
            while (curr < position - 1) {
                previousNode = previousNode.getNext();
                curr++;
            }
            DLLNode currentNode = previousNode.getNext();
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
        }
        return  head;
    }

    public DLLNode deleteNode (DLLNode head, int position) {

        if (position == 1) {
            DLLNode currentNode = head.getNext();
            head = null;
            currentNode.setPrevious(null);
            return currentNode;
        } else {
            int curr = 1;
            DLLNode previousNode = head;
            while (curr < position - 1) {
                previousNode = previousNode.getNext();
                curr++;
            }
            DLLNode nodeToDelete = previousNode.getNext();
            DLLNode nextNode = nodeToDelete.getNext();
            previousNode.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            }
        }
        return head;
    }
}
