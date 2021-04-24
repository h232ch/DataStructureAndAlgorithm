package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = n;

        for (int i = 0; i < n; i++) {

            String word = br.readLine();
            boolean[] check = new boolean[26];

            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j - 1) != word.charAt(j)) {
                    if (check[word.charAt(j) - 97] == true) {
                        result--;
                        break;
                    }
                    check[word.charAt(j - 1) - 97] = true;
                }
            }
        }

        System.out.println(result);

    }
}
