package linkedlist;

import com.lists.linkedlist.ListNode;
import com.lists.linkedlist.SingleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedList {

    public final ListNode node = new ListNode();

    @Before
    public void setUp () {
        ListNode node3 = new ListNode();
        node3.setObj(3);
        node3.setNext(null);
        ListNode node2 = new ListNode();
        node2.setObj(2);
        node2.setNext(node3);
        node.setObj(1);
        node.setNext(node2);

        ListNode printNode = node;
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
        ListNode nodeToInsert = new ListNode();
        nodeToInsert.setObj(4);
        ListNode head = singleLinkedList.insertNode(nodeToInsert, node, 4);
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
        ListNode head = singleLinkedList.deleteNode(node, 2);
        Assert.assertEquals(2, singleLinkedList.listLength(head));
        System.out.println("Modified List");
        while (head != null) {
            System.out.println(head.getObj());
            head = head.getNext();
        }
    }
}
