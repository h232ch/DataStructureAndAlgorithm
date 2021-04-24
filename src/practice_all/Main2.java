package practice_all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       int n = Integer.parseInt(br.readLine());
       StringTokenizer st;

       int a, b;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append("Case #" + i + ": " + a + " + " + b + " = " + (a+b));
        }

        br.close();
        System.out.println(sb);
    }
}
