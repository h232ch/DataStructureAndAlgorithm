package chap05.question;

import java.util.Scanner;

public class q5 {


    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.print(n + ", ");
        }
    }

    static void recur3n(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1; //  첫번째 계산 (sw는 0)

                else if (sw == 1) {
                    n = n - 2; //  두번째 계산 (sw는 1)
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.print(n + ", ");
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sw = sc.nextInt();

        recur3(sw);
        System.out.println();
        recur3n(sw);
    }
}
