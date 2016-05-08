package com.problems;

/**
 * Created by Kunal on 4/25/2016.
 */
public class Recursions {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int findRoutes(int numSteps) {
        if (numSteps == 0) {
            return 0;
        }

        if (numSteps == 1) {
            return 1;
        }

        if (numSteps == 2) {
            return 1 + findRoutes(1);
        }
        return findRoutes(numSteps - 2) + findRoutes(numSteps - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(findRoutes(2));
    }
}


