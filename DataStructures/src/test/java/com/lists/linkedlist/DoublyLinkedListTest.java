package com.lists.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kunal on 3/6/2016.
 */
public class DoublyLinkedListTest {

    public final DLLNode node = new DLLNode();

    @Before
    public void setUp() throws Exception {
        DLLNode node3 = new DLLNode();
        DLLNode node2 = new DLLNode();

        node3.setObj(3);
        node3.setNext(null);
        node3.setPrevious(node2);

        node2.setObj(2);
        node2.setNext(node3);
        node2.setPrevious(node);

        node.setObj(1);
        node.setNext(node2);

        DLLNode printNode = node;
        System.out.println("Original List");
        while (printNode != null) {
            System.out.println(printNode.getObj());
            printNode = printNode.getNext();
        }
    }

    @Test
    public void testListLength() throws Exception {

        DoublyLinkedList dll = new DoublyLinkedList();
        Assert.assertEquals(3, dll.listLength(node));
    }
}