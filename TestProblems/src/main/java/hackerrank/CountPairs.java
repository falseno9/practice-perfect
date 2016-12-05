package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kunal on 12/3/2016.
 */
public class CountPairs {

    static int countPairs(int[] numbers, int k) {

        Set<Integer> uniques = new HashSet<>();
        int numPairs = 0;
        for (int i = 0; i < numbers.length; i++) {
            uniques.add(numbers[i] + k);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (uniques.contains(numbers[i])) {
                uniques.remove(numbers[i]);
                numPairs++;
            }
        }
        return numPairs;
    }
}
