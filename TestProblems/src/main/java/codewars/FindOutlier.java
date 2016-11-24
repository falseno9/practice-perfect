package codewars;

public class FindOutlier {
    static int find(int[] integers) {

        if (findEvenOrOdd(integers[0], integers[1], integers[2])) {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 != 0) {
                    return integers[i];
                }
            }
        } else {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 == 0) {
                    return integers[i];
                }
            }
        }
        return 0;
    }

    private static boolean findEvenOrOdd(int a, int b, int c) {

        if ((a % 2 == 0 && b % 2 == 0) || (b % 2 == 0 && c % 2 == 0) || (a % 2 == 0 && c % 2 == 0)) {
            return true;
        }
        return false;
    }
}