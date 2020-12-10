package chap05;

import java.util.Scanner;

public class Recur {

    static void recur (int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.print(n + " ");
            recur(n - 2);
        }
    }

    static void recur2 (int n) {
        if (n > 0) {
            recur2(n - 2);
            System.out.print(n + " ");
            recur2(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();
        recur(x);
    }
}
