package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int crossSize = 0;
        int countSize = 0;

        for (int i = 0; i < n; i++) {

            System.out.println(countSize);
            System.out.println(crossSize);

            crossSize++;
            countSize += crossSize;
        }
    }
}
