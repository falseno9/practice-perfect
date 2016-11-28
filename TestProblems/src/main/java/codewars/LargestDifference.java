package codewars;

/**
 * Created by Kunal on 11/27/2016.
 */
public class LargestDifference {
    public static int largestDifference(int[] data) {

        Integer minIndex = 0, maxIndex = 0, diff = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {

                int currDiff = j - i;
                if (data[j] >= data[i] && currDiff > diff) {
                    minIndex = i;
                    maxIndex = j;
                    diff = currDiff;
                }
            }
        }
        return maxIndex - minIndex;
    }

    public static void main(String[] args) {
        System.out.println(LargestDifference.largestDifference(new int[]{9, 4, 1, 10, 3, 4, 0, -1, -2}));
        System.out.println(LargestDifference.largestDifference(new int[]{1, 2, 3}));
        System.out.println(LargestDifference.largestDifference(new int[]{3, 2, 1}));
    }
}
