package chap05;

import java.util.Scanner;

public class EightQueenTest {

    static int[] tempStk;

    public static void ex(int num, int leng) {


    }

    public static void eightQueen(int[] stk) {
        int leng = stk.length;
        tempStk = stk;

        for (int i = 0; i < leng; i++) {
            ex(i + 1, leng);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print("Number of Stk : ");
        num = sc.nextInt();

        int[] stk = new int[num];
        eightQueen(stk);
    }
}
