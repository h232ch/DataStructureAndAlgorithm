package chap05.question;

public class q1 {
        public static int factorial(int n) {
        int result = n;
        while (n != 1) {
            result *= n-1;
            n--;
        }
        return result;
    }

    public static int factorialRecursion(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorialRecursion(n-1); // factorialRecursion : 3, 2, 1 / return : 3 * (2) 6, 2 * (1) 2, (0) 1
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorialRecursion(10));
    }
}
