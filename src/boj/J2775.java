package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2775 {

    public static void main(String[] args) throws IOException {

        int[][] apt = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1; // 0~14층, 1호 = 1
            apt[0][i] = i; // 0층,i호 = 0~14
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());

        for (int i = 0; i < limit; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
        }

    }
}
