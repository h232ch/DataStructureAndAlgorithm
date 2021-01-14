package chap06.practice;

import java.util.Scanner;

public class StTest {
    public static void main(String[] args) {

        int n = 4;
        for (int i = 0; i < n; i++) {
//            System.out.println("i : " + i + " , " + " n - 1 : " + (n - 1));
            System.out.printf("%3d %c", i, i == n - 1 ? '\n' : ',');
        }
    }
}
