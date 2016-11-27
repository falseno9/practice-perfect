package codewars;

import java.util.Stack;

public class DigPow {

    public static long digPow(int n, int p) {
        // your code
        Stack<Integer> digits = new Stack();
        int powSum = 0;
        int num = n;
        while (num > 0) {
            digits.push(num % 10);
            num = num / 10;
        }

        while (!digits.isEmpty()) {
            powSum += Math.pow(digits.pop(), p);
            p++;
        }
        if (powSum % n == 0) {
            return powSum / n;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(DigPow.digPow(89, 1));
        System.out.println(DigPow.digPow(92, 1));
        System.out.println(DigPow.digPow(46288, 3));
    }
}
