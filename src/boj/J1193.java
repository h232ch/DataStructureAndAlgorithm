package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int crossSize = 1;
        int countSize = 1;

        while (true) {
            if (n <= countSize) {
                int preCount = countSize - crossSize;
                if (crossSize % 2 == 0) {
                    System.out.println((n - preCount) + "/" + (crossSize - (n - preCount - 1)));
                    break;
                } else {
                    System.out.println(crossSize - (n - preCount - 1) + "/" + (n - preCount));
                    break;
                }
            } else {
                crossSize++;
                countSize += crossSize;
            }
        }
    }
}
