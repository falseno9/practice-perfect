package com.problems;

import com.lists.linkedlist.SingleListNode;

/**
 * Created by Kunal on 4/24/2016.
 */
public class MergeSortedLinkedList {

    public static SingleListNode mergeLists(SingleListNode list1, SingleListNode list2) {

        SingleListNode tempList1 = list1;
        SingleListNode tempList2 = list2;
        SingleListNode mergedList = new SingleListNode();
        SingleListNode tempMergedList = mergedList;

        while(tempList1 != null && tempList2 != null) {
            Integer list1Data = (Integer) tempList1.getObj();
            Integer list2Data = (Integer) tempList2.getObj();

            System.out.println(list1Data+" "+list2Data);
            if (list1Data < list2Data) {
                tempMergedList.setObj(list1Data);
                tempList1 = tempList1.getNext();
            } else {
                tempMergedList.setObj(list2Data);
                tempList2 = tempList2.getNext();
            }
            tempMergedList.setNext(new SingleListNode());
            tempMergedList = tempMergedList.getNext();
        }

        if(tempList1 != null) {
            tempMergedList.setObj(tempList1.getObj());
            tempList1 = tempList1.getNext();
            if(tempList1 != null){
                tempMergedList.setNext(tempList1);
            }
        }

        if(tempList2 != null) {
            tempMergedList.setObj(tempList2.getObj());
            tempList2 = tempList2.getNext();
            if(tempList2 != null){
                tempMergedList.setNext(tempList2);
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        SingleListNode list1 = new SingleListNode();
        SingleListNode list2 = new SingleListNode();
        SingleListNode node3 = new SingleListNode();
        SingleListNode node4 = new SingleListNode();
        SingleListNode node5 = new SingleListNode();
        node5.setObj(12);
        node5.setNext(null);
        node4.setObj(8);
        node4.setNext(node5);
        node3.setObj(5);
        node3.setNext(node4);
        SingleListNode node2 = new SingleListNode();
        node2.setObj(2);
        node2.setNext(node3);
        list1.setObj(1);
        list1.setNext(node2);

        node4 = new SingleListNode();
        node4.setObj(11);
        node3 = new SingleListNode();
        node3.setObj(6);
        node3.setNext(node4);
        node2 = new SingleListNode();
        node2.setObj(4);
        node2.setNext(node3);
        list2.setObj(3);
        list2.setNext(node2);

        SingleListNode mergedList = mergeLists(list1, list2);
        while (mergedList != null) {
            System.out.println(mergedList.getObj());
            mergedList = mergedList.getNext();
        }
    }
}
