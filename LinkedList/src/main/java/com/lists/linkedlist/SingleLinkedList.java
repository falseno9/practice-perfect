package com.lists.linkedlist;

public class SingleLinkedList {

    public int listLength(SingleListNode node) {
        int length = 0;
        if (node == null) {
            return length;
        }

        do  {
            length++;
            node = node.getNext();
        } while (node != null);
        return length;
    }

    public SingleListNode insertNode(SingleListNode nodeToInsert, SingleListNode head, int position) {

        int curr = 1;
        if (position == 1) {
            nodeToInsert.setNext(head);
            return nodeToInsert;
        } else {

            SingleListNode previousNode = head;
            while (curr < position - 1) {
                if (curr < position - 1) {
                    previousNode = previousNode.getNext();
                    curr++;
                }
            }
            SingleListNode nextNode = previousNode.getNext();
            nodeToInsert.setNext(nextNode);
            previousNode.setNext(nodeToInsert);
        }
        return head;
    }

    public SingleListNode deleteNode(SingleListNode head, int position) {

        int curr = 1;
        if(position == 1) {
            return head.getNext();
        } else {
            SingleListNode previousNode = head;
            do {
                if (curr < position - 1) {
                    previousNode = previousNode.getNext();
                    curr++;
                }
                SingleListNode nextNode = previousNode.getNext();
                previousNode.setNext(nextNode.getNext());
            } while (curr < position - 1);
        }
    return head;
    }
}
