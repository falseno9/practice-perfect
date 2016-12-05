package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kunal on 12/4/2016.
 */
public class MaxAlternatePair {

    public static int solution(int[] A) {

        Set<Integer> numbers = new HashSet<>();
        for (int a : A) {
            numbers.add(a);
        }
        int B[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }

        Arrays.sort(B);

        int i = 0;
        int j = 1;
        int maxDistance = 0;
        while (i < B.length && j < B.length) {
            if (B[i] != B[j]) {
                int currDistance = pairDistance(A, B[i], B[j]);
                if (currDistance > maxDistance) {
                    maxDistance = currDistance;
                }
            }
            i++;
            j++;
        }
        return maxDistance;
    }

    static int pairDistance(int[] A, int low, int high) {

        int i = 0;
        int j = A.length - 1;
        boolean foundLow = false;
        boolean foundHigh = false;
        while (!foundLow || !foundHigh) {
            if (!foundLow) {
                if (A[i] == low || A[i] == high) {
                    foundLow = true;
                } else {
                    i++;
                }
            }
            if (!foundHigh) {
                if (A[j] == low || A[j] == high) {
                    foundHigh = true;
                } else {
                    j--;
                }
            }
        }

        return Math.abs(i - j);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 7, 3, 3, 5}));
    }
}
