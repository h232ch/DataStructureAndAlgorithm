package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J10250 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());

        for (int j = 0; j < limit; j++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int custNum = Integer.parseInt(st.nextToken());

            if (custNum % height == 0) {
                System.out.println((height * 100) + (custNum / height));
            } else {
                System.out.println(((custNum % height) * 100) + ((custNum / height) + 1));
            }
        }
    }
}
