package array;

/**
 * Created by Kunal on 5/15/2016.
 */
public class MaxDiffArray {

    public int maxDiff(int[] arr) {

        int len = arr.length;
        int diff = arr[1] - arr[0];
        int minElement = arr[0];

        for(int i = 1;i < len;i++) {
            if(arr[i] - minElement > diff) {
                diff = arr[i] - minElement;
            }

            if(arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        MaxDiffArray maxDiffArray = new MaxDiffArray();
        int arr[] = {1, 2, 6, 80, 100};
        System.out.println(maxDiffArray.maxDiff(arr));

        int arr2[] = {80, 2, 6, 3, 100};
        System.out.println(maxDiffArray.maxDiff(arr2));


    }
}
