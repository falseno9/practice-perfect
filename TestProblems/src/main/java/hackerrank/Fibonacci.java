package hackerrank;

/**
 * Created by Kunal on 12/6/2016.
 */
public class Fibonacci {

    public int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public int fibIterative(int n) {

        int fib1 = 1;
        int fib2 = 1;

        for (int i = 1; i < n; i++) {
            int temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
        }

        return fib1;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibRecursive(20));
        System.out.println(f.fibIterative(20));
    }
}
