package Random;

/**
 * Created by Kunal on 12/7/2016.
 */
public class LongestContigousSubArray {

    public static int maxSubArraySum(int[] a) {
        int maxSum = 0;
        int sumSoFar = 0;
        for (int i = 0; i < a.length; i++) {
            sumSoFar += a[i];
            if (sumSoFar < 0) {
                sumSoFar = 0;
            } else if (sumSoFar > maxSum) {
                maxSum = sumSoFar;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}
