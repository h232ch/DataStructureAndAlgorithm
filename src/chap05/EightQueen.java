package chap05;

import java.util.Scanner;

public class EightQueen {

    static int[] pos;
    public static void print() {
        for (int temp : pos) {
            System.out.print(temp + " ");
        } System.out.println();
    }

    public static void set(int n) {
        for (int i = 0; i < pos.length; i++){
            pos[n] = i;

            if (n == pos.length-1) {
                print();
            } else { 
                set(n + 1);
            } // 반복문 + 조건문 + 재귀 -> 가지치기
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Number : ");
        int n = sc.nextInt();

        pos = new int[n];
        set(0);
    }
}
