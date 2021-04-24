package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class J4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        DecimalFormat df = new DecimalFormat("0.000");
        int[] scores = new int[1000];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int inner = Integer.parseInt(st.nextToken());
            int total = 0;
            double avg = 0;
            int count = 0;
            double result = 0;

            for (int j = 0; j < inner; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                total += scores[j];
            }

            avg = total / inner;

            for (int k = 0; k < inner; k++) {
                if (scores[k] > avg) {
                    count++;
                }
            }

            result = ((double) count / (double) inner) * 100;
            System.out.println(df.format(result) + "%");
        }
    }
}
