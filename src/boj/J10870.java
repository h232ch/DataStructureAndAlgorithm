package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10870 {

    static int fibo(int n) {
        if (n == 1) {
            return 1;
        } else if (n <= 0) {
            return 0;
        } else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }
}
