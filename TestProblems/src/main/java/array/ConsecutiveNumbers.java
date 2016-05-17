package array;

/**
 * Created by Kunal on 5/15/2016.
 */
public class ConsecutiveNumbers {

    public boolean isConsecutive(int[] arr) {

        int len = arr.length;
        int minNum = arr[0];
        int maxNum = arr[0];

        for(int i = 1; i < len; i++) {
            if(arr[i] < minNum) {
                minNum = arr[i];
            }

            if(arr[i] >= maxNum) {
                maxNum = arr[i];
            }
        }
        if(maxNum-minNum+1 == len) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]= {9, 4, 2, 3, 1, 6};

        ConsecutiveNumbers num = new ConsecutiveNumbers();
        System.out.println(num.isConsecutive(arr));
    }
}
