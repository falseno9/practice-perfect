package hackerrank;

/**
 * Created by Kunal on 11/26/2016.
 */
public class SumNumbers {

    static int sum(int[] numbers) {

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
