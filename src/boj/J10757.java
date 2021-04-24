package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J10757 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String a = st.nextToken();
        String b = st.nextToken();

        int maxLength = a.length() > b.length() ? a.length() : b.length();
        int[] typeA = new int[maxLength + 1];
        int[] typeB = new int[maxLength + 1];

        for (int i = a.length() - 1, idx = 0; i >= 0; i--, idx++) {
            typeA[idx] = a.charAt(i) - '0';
        }

        for (int i = b.length() - 1, idx = 0; i >= 0; i--, idx++) {
            typeB[idx] = b.charAt(i) - '0';
        }

        for (int i = 0 ; i < maxLength; i++) {
            int temp = typeA[i] + typeB[i];
            typeA[i] = temp % 10;
            typeA[i + 1] = typeA[i + 1] + (temp / 10);
        }

        for (int i = maxLength; i >= 0; i--) {
            if (i == maxLength && typeA[i] == 0) {

            } else {
                System.out.printf("%d", typeA[i]);
            }
        }
    }
}
