package Random;

/**
 * Created by Kunal on 12/7/2016.
 */
public class ContigiousSumArray {

    private static boolean sumArray(int[] array, int sum) {

        int currentSum = 0;
        int firstIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == sum) {
                return true;
            }

            if (currentSum == sum) {
                return true;
            }
            currentSum += array[i];
            while (currentSum > sum) {
                currentSum -= array[firstIndex];
                firstIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sumArray(new int[]{1, 5, 3, 2, 8}, 10));
        System.out.println(sumArray(new int[]{1, 5, 3, 4, 8}, 10));
        System.out.println(sumArray(new int[]{1, 5, 3, 10, 8}, 10));
        System.out.println(sumArray(new int[]{1, 1, 2, 5, 4, 1, 14}, 10));
    }


}
