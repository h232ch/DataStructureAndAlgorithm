package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2914 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croatia = {
                "c=",
                "c-",
                "dz=",
                "d-",
                "lj",
                "nj",
                "s=",
                "z=",
        };

        String word = br.readLine();
        String temp = word;
        int count = 0;

        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = 0; j < croatia.length; j++) {
                int endIndex = i + croatia[j].length();
                if (endIndex <= word.length()) {
                    String substring = word.substring(i, endIndex);
                    System.out.println(substring + " === " + croatia[j]);
                    if (substring.equals(croatia[j])) {

                        i += 1;
                        temp = temp.replace(substring, "");
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count + temp.length());

    }
}
