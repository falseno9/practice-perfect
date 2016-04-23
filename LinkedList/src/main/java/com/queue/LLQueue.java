package com.queue;

import com.lists.linkedlist.DLLNode;

/**
 * Created by Kunal on 3/27/2016.
 */
public class LLQueue {

    private DLLNode head;

    public void enQueue(int data) {
        if (head.getObj() == null) {
            head.setObj(data);
        } else {
            DLLNode next = new DLLNode(data);
            DLLNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(next);
        }
    }

    public Integer deQueue() {
        Integer data = -1;
        if (head.getObj() == null)
            return -1;
        else {
            data = (Integer) head.getObj();
            head = head.getNext();
        }
        return  data;
    }
}
