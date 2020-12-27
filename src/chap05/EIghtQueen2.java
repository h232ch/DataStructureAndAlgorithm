package chap05;

import java.util.Scanner;

public class EIghtQueen2 {

    static int[] pos;
    static boolean flag[];
    static boolean flag_b[];
    static boolean flag_c[];
//    static char[][] tchar = new char[4][4]; // if use recursion


    static public void print() {

        for (int temp : pos) {
            System.out.print(temp + " ");
        }System.out.println();

        char[][] tchar = new char[pos.length][pos.length];
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos.length; j++) {
                tchar[i][j] = (j == pos[i]) ? '■' : '□';
            }
        }

        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos.length; j++) {
                System.out.print(tchar[j][i]);
            } System.out.println();
        }

//        for (int i = 0; i < pos.length; i++) {
//            for (int j = 0; j < pos.length; j++)
//                System.out.printf("%s", j == pos[i] ? "■" : "□");
//            System.out.println();
//        }
//        System.out.println();

//        print2(0); // Trying to make this recursion
    }

//    public static void print2(int n) {
//        if (n < pos.length) {
//            print2(n+1);
//            for (int i = 0; i < pos.length; i++) {
//                System.out.print(tchar[n][i]);
//            }
//            System.out.println();
//        }
//    }

    public static void set(int n) {
        int l = pos.length;
        for (int i = 0; i < l; i++) {
            if (!flag[i] && // flag : Same row, flab_b : Right Upper Row, flag_c : Left Upper Row
            !flag_b[i + n] && // if flag, flag_b, flag_c are same pos[n] = i; and make flags true, call set(n+1)
            !flag_c[i - n + l]) { // set method checks the flags are true or false
                pos[n] = i;
                if (n == l-1) {
                    print(); // last number of array, call print() method;
                } else {
                    flag[i] = flag_b[i + n] = flag_c[i - n + l]= true;
                    set(n+1);
                    flag[i] = flag_b[i + n] = flag_c[i - n + l] = false; // when comeback to this section, flags are changed to false
                    // it means the number we used will be change in next for statement i;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number : ");
        int num = sc.nextInt();

        flag = new boolean[num];
        flag_b = new boolean[num * 2];
        flag_c = new boolean[num * 2];
        pos = new int[num];

        set(0);
    }
}
