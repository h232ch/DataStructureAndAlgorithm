package chap05_temp;

import java.util.Scanner;

public class Haino {

    static void haino (int num, int src, int dst) {
        if (num > 1) haino(num-1, src, 6-dst-src);
        System.out.println(num + "를 " + src + " 에서 " + dst + "로 옮깁니다.");
        if (num > 1) haino(num-1, 6-dst-src, dst);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number : ");
        int temp = sc.nextInt();

        haino(temp, 1, 3);
    }
}
