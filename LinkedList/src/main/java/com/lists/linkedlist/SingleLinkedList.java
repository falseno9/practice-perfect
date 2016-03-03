package com.lists.linkedlist;


import java.util.List;

/**
 * Created by Kunal on 2/14/2016.
 */
public class SingleLinkedList {

    public int listLength(ListNode node) {
        int length = 0;
        if (node == null) {
            return length;
        }

        while (node.getNext() != null) {
            length++;
        }
        return length;
    }

    public ListNode insertNode(ListNode nodeToInsert, ListNode head, int position) {

        int curr = 1;
        if (position == 1) {
            nodeToInsert.setNext(head);
            return nodeToInsert;
        } else {

            ListNode previousNode = head;
            while (curr < position - 1) {
                if (curr < position - 1) {
                    previousNode = previousNode.getNext();
                    curr++;
                }
            }
            ListNode nextNode = previousNode.getNext();
            nodeToInsert.setNext(nextNode);
            previousNode.setNext(nodeToInsert);
        }
        return head;
    }

    public ListNode deleteNode(ListNode head, int position) {

        int curr = 1;
        if(position == 1) {
            return head.getNext();
        } else {
            ListNode previousNode = head;
            while (curr < position - 1) {
                if (curr < position - 1) {
                    previousNode = previousNode.getNext();
                    curr++;
                }
                ListNode nextNode = previousNode.getNext();
                previousNode.setNext(nextNode.getNext());
            }
        }
    return head;
    }
}
