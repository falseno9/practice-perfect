package com.lists.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedList {

    public final SingleListNode node = new SingleListNode();

    @Before
    public void setUp () {
        SingleListNode node3 = new SingleListNode();
        node3.setObj(3);
        node3.setNext(null);
        SingleListNode node2 = new SingleListNode();
        node2.setObj(2);
        node2.setNext(node3);
        node.setObj(1);
        node.setNext(node2);

        SingleListNode printNode = node;
        System.out.println("Original List");
        while (printNode != null) {
            System.out.println(printNode.getObj());
            printNode = printNode.getNext();
        }
    }

    @Test
    public void testListLength() {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Assert.assertEquals(3, singleLinkedList.listLength(node));

    }

    @Test
    public void testInsertNode() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleListNode nodeToInsert = new SingleListNode();
        nodeToInsert.setObj(4);
        SingleListNode head = singleLinkedList.insertNode(nodeToInsert, node, 2);
        Assert.assertEquals(4, singleLinkedList.listLength(head));
        System.out.println("Modified List");
        while (head != null) {
            System.out.println(head.getObj());
            head = head.getNext();
        }
    }

    @Test
    public void testDeleteNode() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleListNode head = singleLinkedList.deleteNode(node, 2);
        Assert.assertEquals(2, singleLinkedList.listLength(head));
        System.out.println("Modified List");
        while (head != null) {
            System.out.println(head.getObj());
            head = head.getNext();
        }
    }
}
