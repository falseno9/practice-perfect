package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kunal on 12/4/2016.
 */
public class MaxDistancePair {

    public static int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for (int a : A) {
            numbers.add(a);
        }
        int maxPairDistance = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int currPairDistance = j - i;
                if (currPairDistance > maxPairDistance && checkIfPair(numbers, A[i], A[j])) {
                    maxPairDistance = currPairDistance;
                }
            }
        }
        return maxPairDistance;
    }

    static boolean checkIfPair(Set<Integer> numbers, int A, int B) {
        int low;
        int high;

        if (A == B) {
            return false;
        } else if (A < B) {
            low = A;
            high = B;
        } else {
            low = B;
            high = A;
        }

        for (int i = low + 1; i < high; i++) {
            if (numbers.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 7, 3, 3, 5}));
    }
}