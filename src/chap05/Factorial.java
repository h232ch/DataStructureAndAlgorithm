package chap05;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            System.out.println("last");
            return 1;
    }

    static int factorialOn(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *=  i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");

        System.out.println(factorialOn(4));
    }
}
