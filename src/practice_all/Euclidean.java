package practice_all;

public class Euclidean {

    static int euclidean(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return euclidean(n2, n1 % n2);
        }
    }

    static int factorial(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(euclidean(493, 183));
        System.out.println(factorial(5));
    }
}
