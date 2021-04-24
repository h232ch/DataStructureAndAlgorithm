package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J2908 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] result = new int[2];

        for (int j = 0; j < 2; j++) {
            String n = st.nextToken();
            char[] chars = n.toCharArray();

            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[chars.length - 1];
                chars[chars.length - 1] = chars[i];
                chars[i] = temp;
            }
            String temp = String.valueOf(chars);
            result[j] = Integer.parseInt(temp);
        }

        int resultValue = result[0] > result[1] ? result[0] : result[1];
        System.out.println(resultValue);

    }
}
