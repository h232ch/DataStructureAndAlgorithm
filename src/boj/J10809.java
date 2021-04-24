package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10809 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int[] result = new int[26];

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < words.length(); i++) {
            for (int j = 0; j < alpha.length(); j++) {
                if (words.charAt(i) == alpha.charAt(j)) {
                    if (result[j] == -1) {
                        result[j] = i;
                        break;
                    }
                }
            }
        }

        for (int i : result) {
            System.out.printf("%d ", i);
        }
    }
}

