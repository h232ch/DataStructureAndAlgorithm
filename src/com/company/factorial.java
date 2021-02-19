package com.company;

public class factorial {

    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    static int factorialOn(int n) {

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorialOn(4));

    }
}
