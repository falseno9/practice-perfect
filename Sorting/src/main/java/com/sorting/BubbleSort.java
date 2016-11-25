package com.sorting;

/**
 * Created by Kunal on 5/23/2016.
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {

        for(int i = 0; i < arr.length; i++ ) {
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSortImproved(int[] arr) {

        boolean swapped = true;
        for(int i = 0; (i < arr.length) && swapped; i++ ) {
            swapped = false;
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();

        int arr[] = {10,2,9,7,3,8};
        sort.bubbleSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int arr1[] = {10,2,9,7,3,8};
        sort.bubbleSortImproved(arr1);
        for(int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
}
