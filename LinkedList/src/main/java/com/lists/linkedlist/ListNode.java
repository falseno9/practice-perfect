package com.lists.linkedlist;

/**
 * Created by Kunal on 2/14/2016.
 */
public class ListNode {

    private ListNode next;
    private Object obj;

    public ListNode(ListNode next, Object obj) {
        this.next = next;
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
