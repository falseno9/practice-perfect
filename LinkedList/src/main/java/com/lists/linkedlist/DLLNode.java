package com.lists.linkedlist;

/**
 * Created by Kunal on 3/6/2016.
 */
public class DLLNode {

    DLLNode next;
    DLLNode previous;
    Object obj;

    public DLLNode(DLLNode next, DLLNode previous, Object obj) {
        this.next = next;
        this.previous = previous;
        this.obj = obj;
    }

    public DLLNode() {
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
