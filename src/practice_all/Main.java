package practice_all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int factorial(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<char[]> list = new ArrayList<>(n);
        int[] score = new int[n];


        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            list.add(temp.toCharArray());
            char[] obj = list.get(i);


            int midSum = 0;
            int lastSum = 0;

            for (int j = 0; j < obj.length; j++) {
                if (j == obj.length - 1 && obj[j] == 'O') {
                    midSum++;
                    lastSum = lastSum + factorial(midSum);
                    midSum = 0;
                } else if (obj[j] == 'O') {
                    midSum++;
                } else if (midSum != 0 && obj[j] != 'O') {
                    lastSum = lastSum + factorial(midSum);
                    midSum = 0;
                }
            }

            score[i] = lastSum;
        }

        for (int i : score) {
            System.out.println(i);
        }
    }
}
