package boj;

import java.io.IOException;
import java.util.Scanner;

public class J2839 {

    public static void main(String[] args) throws IOException {

        int input = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        while (true) {
            if (input % 5 == 0) {
                System.out.println(input / 5 + count);
                break;
            } else if (input <= 0) {
                System.out.println(-1);
                break;
            }
            input = input - 3;
            count++;
        }
    }
}

