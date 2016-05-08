package com.lists.linkedlist;

public class SingleListNode {

    private SingleListNode next;
    private Object obj;

    public SingleListNode(SingleListNode next, Object obj) {
        this.next = next;
        this.obj = obj;
    }

    public SingleListNode() {}


    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }
}
