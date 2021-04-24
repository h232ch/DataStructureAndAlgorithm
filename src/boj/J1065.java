package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1065 {
    static int hansu(int n) {
        int count = 0;

        if (n < 100) {
            count = n;

        } else {
            count = 99;

            if (n == 1000) {
                n = 999;
            }

            int a,b,c;
            for (int i = 100; i <= n; i++) {

                a = i / 100;
                b = (i / 10) % 10;
                c = i % 10;

                if ((a - b) == (b - c)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(hansu(n));
    }
}

