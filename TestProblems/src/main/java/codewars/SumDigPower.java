package codewars;

import java.util.ArrayList;
import java.util.List;

class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {

        List<Long> result = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            if (checkCondition(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean checkCondition(long num) {
        String s = String.valueOf(num);

        int p = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(Character.getNumericValue(s.charAt(i)), p++);
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 10));
        System.out.println(sumDigPow(1, 100));
        System.out.println(sumDigPow(10, 100));
        System.out.println(sumDigPow(90, 100));
    }
}