package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        word = word.toUpperCase();

        int max = 0;
        char result = '?';
        int[] wordNumber = new int[26];

        for (int i = 0; i < word.length(); i++) {
            wordNumber[word.charAt(i) - 65]++;
            if (max < wordNumber[word.charAt(i) - 65]) {
                max = wordNumber[word.charAt(i) - 65];
                result = word.charAt(i);
            } else if (max == wordNumber[word.charAt(i) - 65]) {
                result = '?';
            }
        }
        System.out.println(result);
        br.close();
    }
}