package com.lists.linkedlist;

/**
 * Created by Kunal on 3/6/2016.
 */
public class DoublyLinkedList {

    public int listLength(DLLNode node) {
        int length = 0;
        if (node != null) {
            do {
                length++;
            } while (node.getNext() != null);
        }
        return length;
    }
}
